package com.bilalmirza.xsandos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class ResultDialogFragment : Fragment() {

    private val gameFragment: Game_Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = ResultDialogFragmentArgs.fromBundle(requireArguments())
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_result_dialog, container, false)

        binding.findViewById<TextView>(R.id.messageText).text = args.result

        binding.findViewById<Button>(R.id.startAgainButton).setOnClickListener {view: View ->
            gameFragment?.reset()
            view.findNavController().navigate(ResultDialogFragmentDirections
                .actionResultDialogFragment2ToGameFragment(args.playerName1, args.playerName2))
        }

        binding.findViewById<Button>(R.id.changeNameButton).setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_resultDialogFragment2_to_addPlayersFragment)
        }

        return binding
    }
}