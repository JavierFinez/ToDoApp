package io.keepcoding.todo.util

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import io.keepcoding.todo.data.model.Task
import io.keepcoding.todo.ui.edittask.EditTaskFragment
import io.keepcoding.todo.ui.newtask.NewTaskActivity
import io.keepcoding.todo.ui.taskdetail.TaskDetailActivity

object Navigator {

    fun navigateToNewTaskActivity(parentTaskId: Long, context: Context) {
        val intent = Intent(context, NewTaskActivity::class.java)
        intent.putExtra("parentTaskId", parentTaskId)
        context.startActivity(intent)
    }

    fun navigateToEditTaskFragment(task: Task, fragmentManager: FragmentManager) : EditTaskFragment {
        val fragment = EditTaskFragment.newInstance(task)
        fragment.show(fragmentManager, null)
        return fragment
    }

    fun navigateToTaskDetailActivity(task: Task, context: Context) {
        val intent = Intent(context, TaskDetailActivity::class.java)
        intent.putExtra("task", task)
        context.startActivity(intent)
    }

}