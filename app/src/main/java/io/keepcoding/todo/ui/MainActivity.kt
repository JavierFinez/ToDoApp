package io.keepcoding.todo.ui

import android.os.Bundle
import com.jakewharton.rxbinding3.view.clicks
import io.keepcoding.todo.R
import io.keepcoding.todo.ui.base.BaseActivity
import io.keepcoding.todo.ui.tasks.TaskFragment
import io.keepcoding.todo.ui.tasks.TaskViewModel
import io.keepcoding.todo.util.Navigator
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar(false)
        setTitle(R.string.app_name)
        setUp()
    }

    private fun setUp() {
        bindActions()

        val fragment = TaskFragment()
        val bundle = Bundle()
        bundle.putLong("parentTaskId", 0)
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun bindActions() {
        fabAddTask
            .clicks()
            .throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                Navigator.navigateToNewTaskActivity(0,this)
            }
            .addTo(compositeDisposable)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}
