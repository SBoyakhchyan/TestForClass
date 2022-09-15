package com.example.testforclass

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.ui.platform.AndroidUiDispatcher.Companion.Main
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testforclass.databinding.FragmentFlowBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class FlowFragment : Fragment() {
    var currentProgress = 0
    private lateinit var progressBar: ProgressBar
    private lateinit var btn_startReset: AppCompatButton

    private lateinit var binding: FragmentFlowBinding
    private val viewModel: TestViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TAG", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //retainInstance = true
        Log.d("TAG", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_flow, container, false)
        binding = FragmentFlowBinding.bind(view)
        Log.d("TAG", "onCreateView")
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("TAG", "onActivityCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("TAG", "onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TAG", "onDetach")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        btn_startReset.setOnClickListener {
            if (btn_startReset.isEnabled)
                progressBar.visibility = View.VISIBLE
                btn_startReset.text = getString(R.string.startReset)
                GlobalScope.launch { asd() }
            }
        }

//    private suspend fun asd() {
//        viewModel.countDownTimer.collect {
//            binding.timerValue.text = it.toString()
//        }
//    }

    private suspend fun asd() {
        viewModel.countDownTimer.collect {
            binding.timerValue.text = it.toString()
            progressBar.max = 10
            CoroutineScope(Main).launch {
                progressBar.progress = it
                if (it == 0) {
                    progressBar.visibility = View.GONE
                }
            }
        }
    }


    private fun initView() {
        progressBar = binding.progressBar
        btn_startReset = binding.btnStartReset
    }
}