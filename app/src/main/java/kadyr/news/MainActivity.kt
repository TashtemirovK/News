package kadyr.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kadyr.common_utils.Activities
import kadyr.common_utils.Navigator
import kadyr.news.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        provider.getActivities(Activities.NewsActivity).navigate(this)
    }
}