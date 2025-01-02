package kadyr.search_presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kadyr.common_utils.Navigator
import kadyr.search_presentation.databinding.ActivitySearchBinding


class SearchActivity : AppCompatActivity() {

    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, SearchActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private var _binding: ActivitySearchBinding? = null
    val binding: ActivitySearchBinding
        get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()
    private val newsAdapter: NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    // https://newsapi.org/v2/everything?q=apple&from=2022-10-14&to=2022-10-14&sortBy=popularity&apiKey=API_KEY

    private fun initView() {
        binding.rvSearch.adapter = newsAdapter
        binding.etSearchTitle.doAfterTextChanged {
            val map = mutableMapOf<String, String>()
            map[Constant.apiKey] = ""
            map[Constant.QUERY] = it.toString()
            viewModel.getSearchArticles(map)
        }
    }


    object GoToSearchActivity : Navigator {
        override fun navigate(activity: Activity) {
            SearchActivity.launchActivity(activity)
        }
    }
}