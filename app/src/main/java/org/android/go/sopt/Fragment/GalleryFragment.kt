package org.android.go.sopt.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.android.go.sopt.databinding.FragmentGalleryBinding


class GalleryFragment:Fragment(){
    private var _binding: FragmentGalleryBinding?=null
    private val binding:FragmentGalleryBinding
        get() = requireNotNull(_binding){ " _binding이 null입니다!" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // 이제 반환하는 View가 Null일 수 없기 때문에, ?를 지워주셔도 됩니다.
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 대부분의 로직은 여기에 구현합니다.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


