package ru.geekbrains.kozirfm.testkotlinapp.view.fragments

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ru.geekbrains.kozirfm.testkotlinapp.R

class AddWorkoutDialog : DialogFragment() {

    companion object {
        val TAG = AddWorkoutDialog::class.java.name + "TAG"

        fun createInstance(addWorkout: (String, String) -> Unit): AddWorkoutDialog {
            return AddWorkoutDialog().apply {
                this.addWorkout = addWorkout
            }
        }

    }

    private var addWorkout: ((String, String) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext())
            .setView(R.layout.add_workout_dialog)
            .setTitle(R.string.workout_title_name)
            .setPositiveButton(R.string.add) { _, _ ->
                val title = dialog?.findViewById<EditText>(R.id.editTextAddWorkoutTitle)
                val text = dialog?.findViewById<EditText>(R.id.editTextAddWorkoutText)
                addWorkout?.invoke(title?.text.toString(), text?.text.toString())
            }
            .setNegativeButton(R.string.cancel) { _, _ ->
                dismiss()
            }
            .create()
    }

}