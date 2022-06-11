package com.example.navigationone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.navigationone.CLASS.User
import com.example.navigationone.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding:FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding =  FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstNext.setOnClickListener {

            val text = binding.usernameId.text.toString()
            val textTwo = binding.passwordId.text.toString()

            val bundle = Bundle()
/*            bundle.putString("a",text)
            bundle.putString("b",textTwo)*/

            val user = User(binding.usernameId.text.toString(), binding.passwordId.text.toString())

            bundle.putSerializable("s",user)

            val builder = NavOptions.Builder()

            builder.setEnterAnim(R.anim.exit_anim)
            builder.setExitAnim(R.anim.pop_enter_anim)
            builder.setPopEnterAnim(R.anim.enter_anim)
            builder.setPopExitAnim(R.anim.pop_exit_anim)

            findNavController().navigate(R.id.thirdFragment,bundle,builder.build())

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}