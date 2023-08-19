package com.android.base_mvvm.utils.ext

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.android.base_mvvm.BuildConfig
import com.android.base_mvvm.R
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <T : Any?> Fragment.collectFlowOn(
    sharedFlow: SharedFlow<T>,
    lifecycleState: Lifecycle.State = Lifecycle.State.CREATED,
    onResult: suspend (t: T) -> Unit,
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
            sharedFlow.collectLatest {
                onResult.invoke(it)
            }
        }
    }
}

fun <T : Any?> Fragment.collectFlowOn(
    stateFlow: StateFlow<T>,
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    onResult: suspend (t: T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
            stateFlow.collect {
                onResult.invoke(it)
            }
        }
    }
}

fun Fragment.runLifecycleCoroutine(lifecycleState: Lifecycle.State = Lifecycle.State.CREATED, onHandle: suspend () -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
            onHandle.invoke()
        }
    }
}

fun Fragment.rateApp() {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data =
        Uri.parse("http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)
    startActivity(intent)
}

fun Fragment.openUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}

enum class TransitionType {
    SIBLING, DETAIL, MODAL
}

inline fun <reified T : Fragment> FragmentManager.handleReplace(
    containerId: Int,
    transitionType: TransitionType? = TransitionType.DETAIL,
    fragment: T,
    sharedElement: View? = null,
    isBackStack: Boolean = true
) {
    val tag: String = fragment::class.java.name
    beginTransaction().apply {
        transitionType?.let { setTransition(it) }
        sharedElement?.let {
            addSharedElement(sharedElement, sharedElement.transitionName)
        }
        setReorderingAllowed(true)
        replace(containerId, fragment, tag)
        if (isBackStack) addToBackStack(tag)
        commitAllowingStateLoss()
    }
}

inline fun <reified T : Fragment> FragmentManager.handleAdd(
    containerId: Int,
    transitionType: TransitionType? = TransitionType.DETAIL,
    fragment: T,
    sharedElement: View? = null
) {
    val tag: String = fragment::class.java.name
    beginTransaction().apply {
        transitionType?.let { setTransition(it) }
        sharedElement?.let {
            addSharedElement(sharedElement, sharedElement.transitionName)
        }
        setReorderingAllowed(true)
        add(containerId, fragment, tag)
        addToBackStack(tag)
        commitAllowingStateLoss()
    }
}

fun FragmentTransaction.setTransition(transitionType: TransitionType) {
    setCustomAnimations(
        when (transitionType) {
            TransitionType.SIBLING -> R.anim.fade_in
            TransitionType.DETAIL -> R.anim.slide_in
            TransitionType.MODAL -> R.anim.slide_in
        },
        R.anim.fade_out,
        R.anim.fade_in,
        when (transitionType) {
            TransitionType.SIBLING -> R.anim.fade_out
            TransitionType.DETAIL -> R.anim.slide_out
            TransitionType.MODAL -> R.anim.slide_out
        }
    )
}

inline fun <reified T : Fragment> FragmentManager.remove(
    fragment: T
) {
    beginTransaction().apply {
        remove(fragment)
        commitAllowingStateLoss()
    }
}

//fun Fragment.fragmentLogEventTracking(firebaseAnalytics: FirebaseAnalytics) {
//    val bundle = Bundle()
//    bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, this.javaClass.simpleName)
//    bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, this.javaClass.simpleName)
//
//    firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
//}