package com.tsu.catandactivityvisualnovel

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tsu.catandactivityvisualnovel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1Start.setOnClickListener {
            val intent = Intent(this, GamePlay::class.java)
            intent.putExtra(PageName.page, "2")
            startActivity(intent)
            finish()
        }
    }
}
//
//class FirstFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val view = inflater.inflate(R.layout.fragment_first, container, false)
//        val startButton: Button = view.findViewById(R.id.button_start)
//        startButton.setOnClickListener {
//            (activity as MainActivity).goToNextPage()
//        }
//        return view
//    }
//}
//
//class SecondFragment : Fragment() {
//
//    private lateinit var editTextUserName: EditText
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val view = inflater.inflate(R.layout.fragment_second, container, false)
//        editTextUserName = view.findViewById(R.id.edit_text_username)
//        val acceptButton: Button = view.findViewById(R.id.button_accept)
//        acceptButton.setOnClickListener {
//            val username = editTextUserName.text.toString()
//            (activity as MainActivity).goToNextPage(username)
//        }
//        return view
//    }
//
//    fun setUserName(username: String) {
//        editTextUserName.setText(username)
//    }
//}
//
//class ThirdFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val view = inflater.inflate(R.layout.fragment_third, container, false)
//        return view
//    }
//}
//
//class PageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
//
//    private val fragments = arrayOf(FirstFragment(), SecondFragment(), ThirdFragment())
//
//    override fun getItemCount(): Int {
//        return fragments.size
//    }
//
//    override fun createFragment(position: Int): Fragment {
//        return fragments[position]
//    }
//
//    fun getFragment(position: Int): Fragment? {
//        return fragments.getOrNull(position)
//    }
//}