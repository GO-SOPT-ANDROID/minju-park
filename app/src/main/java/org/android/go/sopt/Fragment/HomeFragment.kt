package org.android.go.sopt.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import org.android.go.sopt.Adapter.HAdapter
import org.android.go.sopt.Adapter.RVAdapter
import org.android.go.sopt.Data.HomeViewModel
import org.android.go.sopt.Data.RVData
import org.android.go.sopt.R
import org.android.go.sopt.databinding.FragmentHomeBinding


class HomeFragment:Fragment(){
    //_binding은 Nullable
    private var _binding: FragmentHomeBinding?=null
    //binding은 Nullable하지 않음
    private val binding:FragmentHomeBinding
        get() = requireNotNull(_binding){ " 앗! _binding이 null이다!" }

    private val viewModel by viewModels<HomeViewModel>()

    //메모리 누수를 방지하기 위해 ragment에서 ViewBinding은 onCreateView에서 생성
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // 이제 반환하는 View가 Null일 수 없기 때문에, ?를 지워주셔도 됩니다.
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 대부분의 로직은 여기에 구현합니다.
        val Header=HAdapter(requireContext())
        val RV=RVAdapter(requireContext())

        RV.submitList(viewModel.mokMusicList)
        binding.rvPlaylist.adapter=ConcatAdapter(Header,RV)
    }

    //메모리 누수를 방지하기 위해 null 해제를 직접
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}



