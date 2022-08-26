package com.example.testforclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.ui.platform.AndroidUiDispatcher.Companion.Main
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testforclass.databinding.FragmentFlowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FlowFragment : Fragment() {
    var currentProgress = 0
    private lateinit var progressBar: ProgressBar
    private lateinit var btn_startReset: AppCompatButton

    private lateinit var binding: FragmentFlowBinding
    private val viewModel: TestViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_flow, container, false)
        binding = FragmentFlowBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
            btn_startReset.setOnClickListener {
                if (btn_startReset.isEnabled) {
                    progressBar.visibility = View.VISIBLE
                    btn_startReset.text = getString(R.string.startReset)
                GlobalScope.launch { asd() }
                }
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