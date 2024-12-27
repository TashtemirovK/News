package kadyr.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import kadyr.common_utils.Activities
import kadyr.common_utils.Navigator
import kadyr.news.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var provider: Navigator.Provider
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        provider.getActivities(Activities.SearchActivity).navigate(this)
    }
}