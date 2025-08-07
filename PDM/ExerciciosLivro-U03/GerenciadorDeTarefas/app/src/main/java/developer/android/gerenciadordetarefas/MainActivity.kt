package developer.android.gerenciadordetarefas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
// Você precisará importar R se ainda não estiver importado automaticamente
import developer.android.gerenciadordetarefas.R


class MainActivity : AppCompatActivity() {
    private lateinit var taskAdapter: TaskAdapter
    private val taskList = ArrayList<Task>()
    private lateinit var taskListView: ListView // Declare o ListView
    private lateinit var taskEditText: EditText
    private lateinit var addTaskButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialize as views usando findViewById
        taskListView = findViewById(R.id.taskListView)
        taskEditText = findViewById(R.id.taskEditText) // Supondo que você tenha este ID
        addTaskButton = findViewById(R.id.addTaskButton) // Supondo que você tenha este ID

        taskAdapter = TaskAdapter(this, taskList)
        taskListView.adapter = taskAdapter

        addTaskButton.setOnClickListener {
            val description = taskEditText.text.toString().trim()
            if (description.isNotEmpty()) {
                val task = Task(description)
                taskList.add(task)
                taskAdapter.notifyDataSetChanged()
                taskEditText.text.clear()
            }
        }
    }
}
        