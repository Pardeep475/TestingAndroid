package mobile.android.testapplication

import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import mobile.android.testapplication.adapter.MainAdapter
import mobile.android.testapplication.base.BaseActivity
import mobile.android.testapplication.databinding.ActivityMainBinding
import mobile.android.testapplication.model.APIResponseModelElement
import mobile.android.testapplication.network.IApiResponse
import mobile.android.testapplication.utils.ItemDecorationMain
import mobile.android.testapplication.utils.MyPreferences
import mobile.android.testapplication.viewmodel.MainViewModel
import org.json.JSONArray


class MainActivity : BaseActivity(), IApiResponse {

    private lateinit var myActivityMainBinding: ActivityMainBinding

    //    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var mainAdapter: MainAdapter
    private lateinit var viewModel: MainViewModel
    val itemList = arrayListOf<APIResponseModelElement>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myActivityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        checkTheme()
        initViews()
    }
// initialize views
    private fun initViews() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.initApiResponseListener(this)

        myActivityMainBinding.idItemRv.addItemDecoration(
            ItemDecorationMain(
                resources.getDimension(R.dimen.list_spacing).toInt(),
                2
            )
        )
//        gridLayoutManager = GridLayoutManager(this, 2)
//        myActivityMainBinding.idItemRv.layoutManager = gridLayoutManager

        mainAdapter = MainAdapter(this, itemList)

        myActivityMainBinding.idItemRv.adapter = mainAdapter

        myActivityMainBinding.idItemRv.showShimmerAdapter()
        fetchDataFromServer()
    }
// fetching data from web services
    private fun fetchDataFromServer() {
        if (isInternetIsAvailable(this)) {
            Handler().postDelayed(Runnable {
                viewModel.fetchData(0)
            }, 200)

        } else {
            showSnackBar(
                window.decorView.rootView,
                getString(R.string.no_internet_connection)
            )
            myActivityMainBinding.idItemRv.hideShimmerAdapter()
        }
    }
// Handle success response
    override fun OnApiSuccessResponse(response: LiveData<String>, successType: String) {
        println("success message printed")
        val jsonArray = JSONArray(response.value)
        println("result_is :-  ${jsonArray.length()}")
        for (i in 0 until jsonArray.length()) {
            val item = jsonArray.getJSONObject(i)
            val result = Gson().fromJson(item.toString(), APIResponseModelElement::class.java)
            itemList.add(result)
            // Your code here
        }
        println("result_is :-  ${itemList.size}")
        println("result_is :-  ${itemList[0].download_url}")

        mainAdapter.notifyDataSetChanged()
        myActivityMainBinding.idItemRv.hideShimmerAdapter()
    }
// Handle error during fetching the data from web services
    override fun OnApiErrorResponse(error: LiveData<String>, errorType: String) {
        println("error message printed")
        myActivityMainBinding.idItemRv.hideShimmerAdapter()
    }

    // change theme
    private fun chooseThemeDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.choose_theme_text))
        val styles = arrayOf("Light", "Dark", "System default")
        val checkedItem = 0

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->

            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    MyPreferences(this).darkMode = 0
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    MyPreferences(this).darkMode = 1
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    MyPreferences(this).darkMode = 2
                    delegate.applyDayNight()
                    dialog.dismiss()
                }

            }
        }
        val dialog = builder.create()
        dialog.show()
    }
    // check theme at the starting level
    private fun checkTheme() {
        when (MyPreferences(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
            }
        }
    }

    // create an action bar button
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // handle button activities
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.change_theme) {
            chooseThemeDialog()
        }
        return super.onOptionsItemSelected(item)
    }

}