package com.bilalmirza.xsandos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bilalmirza.xsandos.databinding.FragmentGameBinding

class Game_Fragment : Fragment() {

    private lateinit var gameBinding: FragmentGameBinding

//    1st player --> X so
//    0 --> X
//    1 --> O
//    2 --> NULL
    private var activePlayer = 0

    private var gameOver: Boolean = false

    private var gameStateList = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    private var borderGameStateList = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

    private val winningPositions = arrayListOf(
        arrayOf(0, 1, 2), arrayOf(3, 4, 5), arrayOf(6, 7, 8), arrayOf(0, 3, 6),
        arrayOf(1, 4, 7), arrayOf(2, 5, 8), arrayOf(2, 4, 6), arrayOf(0, 4, 8)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = Game_FragmentArgs.fromBundle(requireArguments())
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_game, container, false)

        binding.findViewById<TextView>(R.id.TPlayerOneName).text = args.name1
        binding.findViewById<TextView>(R.id.TPlayerTwoName).text = args.name2


        binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
        //  FOR IMAGE 1, INDEX 0
        binding.findViewById<ImageView>(R.id.image1).setOnClickListener {view: View ->
            if (borderGameStateList[0] == 2) {
                borderGameStateList[0] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[0] == 2) {
                gameStateList[0] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image1).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            args.name1 + " is the winner!",
                            args.name1,
                            args.name2
                        ))
                    }
                    if (draw()){
                        view.findNavController()
                            .navigate(Game_FragmentDirections.actionGameFragmentToResultDialogFragment2(
                                "Match Drawn", args.name1, args.name2))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image1).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController()
                            .navigate(Game_FragmentDirections.actionGameFragmentToResultDialogFragment2(
                                "Match Drawn",
                                args.name1,
                                args.name2
                            ))
                    }
                    0
                }
            }
        }
        //  FOR IMAGE 2, INDEX 1
        binding.findViewById<ImageView>(R.id.image2).setOnClickListener {view: View ->
            if (borderGameStateList[1] == 2) {
                borderGameStateList[1] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[1] == 2) {
                gameStateList[1] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image2).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name1 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image2).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    0
                }
            }
        }
        //  FOR IMAGE 3, INDEX 2
        binding.findViewById<ImageView>(R.id.image3).setOnClickListener {view: View ->
            if (borderGameStateList[2] == 2) {
                borderGameStateList[2] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[2] == 2) {
                gameStateList[2] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image3).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name1 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image3).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    0
                }
            }
        }
        //  FOR IMAGE 4, INDEX 3
        binding.findViewById<ImageView>(R.id.image4).setOnClickListener {view: View ->
            if (borderGameStateList[3] == 2) {
                borderGameStateList[3] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[3] == 2) {
                gameStateList[3] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image4).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name1 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image4).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    0
                }
            }
        }
        //  FOR IMAGE 5, INDEX 4
        binding.findViewById<ImageView>(R.id.image5).setOnClickListener {view: View ->
            if (borderGameStateList[4] == 2) {
                borderGameStateList[4] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[4] == 2) {
                gameStateList[4] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image5).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name1 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image5).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    0
                }
            }
        }
        //  FOR IMAGE 6, INDEX 5
        binding.findViewById<ImageView>(R.id.image6).setOnClickListener {view: View ->
            if (borderGameStateList[5] == 2) {
                borderGameStateList[5] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[5] == 2) {
                gameStateList[5] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image6).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name1 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image6).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    0
                }
            }
        }
        //  FOR IMAGE 7, INDEX 6
        binding.findViewById<ImageView>(R.id.image7).setOnClickListener {view: View ->
            if (borderGameStateList[6] == 2) {
                borderGameStateList[6] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[6] == 2) {
                gameStateList[6] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image7).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name1 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image7).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    0
                }
            }
        }
        //  FOR IMAGE 8, INDEX 7
        binding.findViewById<ImageView>(R.id.image8).setOnClickListener {view: View ->
            if (borderGameStateList[7] == 2) {
                borderGameStateList[7] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[7] == 2) {
                gameStateList[7] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image8).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name1 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image8).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    0
                }
            }
        }
        //  FOR IMAGE 9, INDEX 8
        binding.findViewById<ImageView>(R.id.image9).setOnClickListener {view: View ->
            if (borderGameStateList[8] == 2) {
                borderGameStateList[8] = activePlayer
                if (activePlayer == 0) {
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.black_border)
                } else {
                    binding.findViewById<LinearLayout>(R.id.playerTwoLayout).setBackgroundResource(R.drawable.white_box)
                    binding.findViewById<LinearLayout>(R.id.playerOneLayout).setBackgroundResource(R.drawable.black_border)
                }
            }
            if (gameStateList[8] == 2) {
                gameStateList[8] = activePlayer
                activePlayer = if (activePlayer == 0) {
                    binding.findViewById<ImageView>(R.id.image9).setImageResource(R.drawable.x_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name1 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    1
                } else {
                    binding.findViewById<ImageView>(R.id.image9).setImageResource(R.drawable.o_big_icon)
                    //  CHECKING WINNER
                    if (result()){
                        view.findNavController().navigate(Game_FragmentDirections
                            .actionGameFragmentToResultDialogFragment2(
                                args.name2 + " is the winner!",
                                args.name1,
                                args.name2
                            ))
                    }
                    if (draw()){
                        view.findNavController().navigate(Game_FragmentDirections.
                        actionGameFragmentToResultDialogFragment2(
                            "Match Drawn",
                            args.name1,
                            args.name2
                        ))
                    }
                    0
                }
            }
        }

        return binding
    }

    private fun result(): Boolean {
        var response = false
        for (i in winningPositions.indices) {
            val combination: Array<Int> = winningPositions[i]
            if (gameStateList[combination[0]] == activePlayer && gameStateList[combination[1]] ==
                activePlayer && gameStateList[combination[2]] == activePlayer) {
                gameOver = true
                response = true
            }
        }
        return response
    }

    private fun draw(): Boolean {
        var emptySquare = false

        for (squareState in gameStateList) {
            if (squareState == 2) {
                emptySquare = true
                break
            }
        }

        return if (!emptySquare && !gameOver) {
            gameOver = true
            true
        } else{
            false
        }
    }

    fun reset(){
        activePlayer = 0
        gameOver = false
        gameStateList = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
        borderGameStateList = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

        gameBinding.image1.setImageResource(R.drawable.white_box)
        gameBinding.image2.setImageResource(R.drawable.white_box)
        gameBinding.image3.setImageResource(R.drawable.white_box)
        gameBinding.image4.setImageResource(R.drawable.white_box)
        gameBinding.image5.setImageResource(R.drawable.white_box)
        gameBinding.image6.setImageResource(R.drawable.white_box)
        gameBinding.image7.setImageResource(R.drawable.white_box)
        gameBinding.image8.setImageResource(R.drawable.white_box)
        gameBinding.image9.setImageResource(R.drawable.white_box)
    }
}