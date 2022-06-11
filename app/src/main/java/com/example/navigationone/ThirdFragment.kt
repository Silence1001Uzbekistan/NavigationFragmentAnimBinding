package com.example.navigationone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationone.CLASS.User
import com.example.navigationone.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding:FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        val string = arguments?.getString("a")
        val string1 = arguments?.getString("b")*/

        val serializable = arguments?.getSerializable("s") as User

        binding.thirdText.text = "${serializable.username} ${serializable.password}"

        binding.thirdText.setOnClickListener {

            findNavController().popBackStack()//O'zini yopadi
            findNavController().popBackStack(R.id.firstFragment,true)//birinchi oynaga o'tadi


        }

    }


}