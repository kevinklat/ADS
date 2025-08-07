package developer.android.gerenciadordetarefas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TaskAdapter(context: Context, private val tasks: ArrayList<Task>) :
    ArrayAdapter<Task>(context, 0, tasks) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
        }

        val task = getItem(position)
        itemView?.findViewById<TextView>(android.R.id.text1)?.text = task?.description

        return itemView!!
    }

}