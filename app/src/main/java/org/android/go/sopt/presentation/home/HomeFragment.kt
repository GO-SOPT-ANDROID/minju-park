package org.android.go.sopt.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.data.remote.ServicePool
import org.android.go.sopt.data.remote.model.ResponseReqresDto
import org.android.go.sopt.data.remote.model.ResponseSignInDto
import org.android.go.sopt.databinding.FragmentHomeBinding
import org.android.go.sopt.util.makeToastMessage
import retrofit2.Call
import retrofit2.Response


class HomeFragment:Fragment(){
    private var _binding: FragmentHomeBinding?=null
    private val binding:FragmentHomeBinding

        get() = requireNotNull(_binding){ " 앗! _binding이 null이다!" }

    private val memberService=ServicePool.reqresService

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
        memberService.getMembers().enqueue(object : retrofit2.Callback<ResponseReqresDto> {
            override fun onResponse(
                call: Call<ResponseReqresDto>,
                response: Response<ResponseReqresDto>,
            ) {
                if (response.isSuccessful) {
                    Log.d("프로필 조회 성공\n", response.body()?.data.toString())
                    binding.rvMember.adapter = RVAdapter()
                        .apply {
                        submitList(response.body()?.data)
                    }
                } else {
                    Snackbar.make(
                        binding.root,
                        "프로필 조회 실패",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            override fun onFailure(call: Call<ResponseReqresDto>, t: Throwable) {
                Snackbar.make(
                    binding.root,
                    "프로필 조회 실패",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        })
    }
}



