package com.example.stackoverflowclone.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflowclone.R
import com.example.stackoverflowclone.activities.MainActivity
import com.example.stackoverflowclone.api.GetAPICallback
import com.example.stackoverflowclone.databinding.FragmentHomeBinding
import com.example.stackoverflowclone.model.APIError
import com.example.stackoverflowclone.model.Question
import com.example.stackoverflowclone.model.Questions
import com.example.stackoverflowclone.rv.RvItem
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private var adapter: GroupAdapter<GroupieViewHolder>? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = "/api/so/questions"

        getResponseApi(url)

        searchBar.tooltipText = "fndj"

        binding = FragmentHomeBinding.bind(view)
        binding.btnAsqQuestion.text = "Ask Question"

        binding.btnAsqQuestion.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToAskFragment()
            val navController =
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
            navController.navigate(action)
        }

    }


    private fun getResponseApi(fullUrl: String) {

        GetAPICallback.postData(
            object : GetAPICallback.ThisCallback {

                @RequiresApi(Build.VERSION_CODES.N)
                override fun onSuccess(jo: JsonObject) {

                    Log.i(LOG_TAG, "onSuccess $LOG_TAG")

                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val questions = gson.fromJson(jo, Questions::class.java)

                    updateUI(questions)

                }


                override fun onFailure(message: String?) {
                    Log.e(LOG_TAG, "onFailure $message $LOG_TAG")
                }


                override fun onError(apiError: APIError) {
                    Log.e(LOG_TAG, "onError $apiError $LOG_TAG")
                }

            },
            fullUrl
        )

    }


    private fun updateUI(questions: Questions?) {

        adapter = GroupAdapter()

        for (q in questions!!.questions) {

            val gson = Gson()
            val question = gson.toJson(q, Question::class.java)

            adapter!!.add(RvItem(activity as MainActivity, question))
        }

        rvItem.layoutManager = LinearLayoutManager(activity)
        rvItem.adapter = adapter
    }


    companion object {

        val LOG_TAG = HomeFragment::class.java.canonicalName
    }

}
