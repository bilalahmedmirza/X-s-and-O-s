package com.bilalmirza.xsandos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class AddPlayersFragment : Fragment() {

    private lateinit var player1Name: EditText
    private lateinit var player2Name: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_add_players, container, false)

        player1Name = binding.findViewById(R.id.enterPlayerOneName)
        player2Name = binding.findViewById(R.id.enterPlayerTwoName)


        binding.findViewById<Button>(R.id.startGameButton).setOnClickListener { view: View ->
            if (player1Name.text.toString().isEmpty() || player2Name.text.toString().isEmpty()){
                Toast.makeText(context, "Please enter the names of both players.", Toast.LENGTH_SHORT).show()
            }
            else {
                view.findNavController().navigate(
                    AddPlayersFragmentDirections.actionAddPlayersFragmentToGameFragment(
                        player1Name.text.toString(),
                        player2Name.text.toString()
                    )
                )
            }
        }
        return binding
    }
}