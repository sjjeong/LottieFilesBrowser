package com.googry.lottiefilesbrowser.ui.home

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.googry.lottiefilesbrowser.BR
import com.googry.lottiefilesbrowser.R
import com.googry.lottiefilesbrowser.base.ui.BaseFragment
import com.googry.lottiefilesbrowser.base.ui.SimpleRecyclerView
import com.googry.lottiefilesbrowser.databinding.HomeFragmentBinding
import com.googry.lottiefilesbrowser.databinding.LottieFileItemBinding
import com.googry.lottiefilesbrowser.network.model.LottieInfoResponse
import com.googry.lottiefilesbrowser.util.EndlessRecyclerViewScrollListener
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = homeViewModel
        binding.rvLottieFile.run {
            adapter =
                object : SimpleRecyclerView.Adapter<LottieInfoResponse, LottieFileItemBinding>(
                    R.layout.lottie_file_item,
                    BR.item
                ) {

                    override fun onCreateViewHolder(
                        parent: ViewGroup,
                        viewType: Int
                    ): SimpleRecyclerView.ViewHolder<LottieFileItemBinding> {
                        return super.onCreateViewHolder(parent, viewType).apply {
                            binding.lavContent.addLottieOnCompositionLoadedListener {
                                val (width, height) = it.bounds.let {
                                    (it.right - it.left) to (it.bottom - it.top)
                                }
                                val lottieView = binding.lavContent
                                binding.lavContent.layoutParams =
                                    binding.lavContent.layoutParams.apply {
                                        this.height = lottieView.width * height / width
                                    }
                            }
                        }
                    }

                }
            addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager!!) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                    homeViewModel.onLoad(page)
                }
            })
        }
    }

    companion object {
        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

}