package com.example.stackoverflowclone.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.stackoverflowclone.R
import com.example.stackoverflowclone.api.PostAPICallback
import com.example.stackoverflowclone.fragments.HomeFragment.Companion.LOG_TAG
import com.example.stackoverflowclone.model.APIError
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.fragment_ask.*

class AskFragment : Fragment(R.layout.fragment_ask) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = "/api/so/questions"
        val headerAuth = "85514581-cc50-4490-8612-6a288842ff64"


        btnSave.setOnClickListener {
            if (etTitle.text.toString() != "" && etBody.text.toString() != "") {
                getResponseApi(url, headerAuth)
            } else {
                Toast.makeText(requireActivity(), "Empty value not allowed", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }


    private fun getResponseApi(url: String, headerAuth: String) {
        val jo = JsonObject()
        jo.addProperty("title", etTitle.text.toString())
        jo.addProperty("creationDate", 1606106807178)
        jo.addProperty("description", etBody.text.toString())

        PostAPICallback.postData(object : PostAPICallback.ThisCallback {

            override fun onSuccess(jo: JsonObject) {
                Log.e(LOG_TAG, "success")
            }

            override fun onFailure(message: String?) {
                Log.e(LOG_TAG, message!!)
            }

            override fun onError(apiError: APIError) {
                Log.e(LOG_TAG, apiError.errorMessage!!)
            }

        }, headerAuth, url, jo)
    }
}