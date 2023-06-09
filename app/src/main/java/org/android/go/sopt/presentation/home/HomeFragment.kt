package org.android.go.sopt.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import org.android.go.sopt.data.remote.ServicePool
import org.android.go.sopt.data.remote.model.ResponseReqresDto
import org.android.go.sopt.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { " 앗! _binding이 null이다!" }

    private val memberService = ServicePool.reqresService
    private val viewModel by viewModels<HomeViewmodel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser()
        viewModel.getUserResult.observe(viewLifecycleOwner) { getUserResult ->
            connetAdapter(getUserResult.data)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun connetAdapter(userList: List<ResponseReqresDto.ReqresData>) {
        val rvAdapter = RVAdapter()
        rvAdapter.submitList(userList)

        binding.rvMember.adapter = rvAdapter
        binding.rvMember.layoutManager = LinearLayoutManager(requireContext())
    }
}
