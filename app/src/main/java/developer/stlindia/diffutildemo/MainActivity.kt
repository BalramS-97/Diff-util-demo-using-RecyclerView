package developer.stlindia.diffutildemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.listRecycler)

        val adapter = DataAdapter()

        val data1 = dataItem(1, "J", "Java")
        val data2 = dataItem(2, "K", "Kotlin")
        val data3 = dataItem(3, "P", "Python")
        val data4 = dataItem(4, "G", "GoLang")

        adapter.submitList(listOf(data1, data2, data3, data4))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        /**Handler class allow us to write some code in Main Thread**/
        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val data1 = dataItem(1, "A", "Android")
            val data2 = dataItem(2, "K", "Kotlin")
            val data3 = dataItem(3, "P", "Python")
            val data4 = dataItem(4, "G", "GoLang")
            val data5 = dataItem(5, "S", "Swift")
            val data6 = dataItem(6, "J", "Java")

            adapter.submitList(listOf(data1, data2, data3, data4, data5, data6))

        }, 5000)
    }

}