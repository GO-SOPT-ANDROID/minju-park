package org.android.go.sopt.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import org.android.go.sopt.databinding.FragmentHomeBinding


class HomeFragment:Fragment(){
    private var _binding: FragmentHomeBinding?=null
    private val binding:FragmentHomeBinding
        get() = requireNotNull(_binding){ " 앗! _binding이 null이다!" }

    private val viewModel by viewModels<HomeViewModel>()

    //메모리 누수를 방지하기 위해 ragment에서 ViewBinding은 onCreateView에서 생성
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 대부분의 로직은 여기에 구현합니다.
        val Header= HAdapter(requireContext())
        val RV= RVAdapter(requireContext())

        RV.submitList(viewModel.mokMusicList)
        binding.rvPlaylist.adapter=ConcatAdapter(Header,RV)
    }

    //메모리 누수를 방지하기 위해 null 해제를 직접
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}



