package kadyr.news_presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kadyr.common_utils.Navigator
import kadyr.news_presentation.databinding.ActivityNewsBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.isActive

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, NewsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private var _binding: ActivityNewsBinding? = null
    private val binding: ActivityNewsBinding
        get() = _binding!!

    private val newsViewModel: NewsViewModel by viewModels()

    private val newsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        setObservers()
    }

    private fun initView() {
        binding.rvArticles.adapter = newsAdapter
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            newsViewModel.newsArticle.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }

                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@NewsActivity, it.error, Toast.LENGTH_SHORT).show()
                }
                it.data?.let {
                    binding.progressBar.visibility = View.GONE
                    newsAdapter.setData(it)
                }
            }
        }

    }
}

object GoToNewsActivity : Navigator {
    override fun navigate(activity: Activity) {
        NewsActivity.launchActivity(activity)
    }
}