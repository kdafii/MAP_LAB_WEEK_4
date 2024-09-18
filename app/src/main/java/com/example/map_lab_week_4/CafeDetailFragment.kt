package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CafeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val TAB_CONTENT = "TAB_CONTENT"
class CafeDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val cafeDesc: TextView?
        get() = view?.findViewById(R.id.cafe_desc)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cafeId = arguments?.getInt(CAFE_ID, 0) ?: 0
        setCafeData(cafeId) // Use the passed cafeId from arguments
    }


    fun setCafeData(id: Int){
        when(id){
            CAFE_STARBUCKS -> {
                cafeDesc?.text = getString(R.string.starbucks_desc)
            }
            CAFE_JANJIJIWA -> {
                cafeDesc?.text = getString(R.string.janjijiwa_desc)
            }
            CAFE_KOPIKENANGAN -> {
                cafeDesc?.text = getString(R.string.kopikenangan_desc)
            }
        }
    }

    companion object {
        private const val CAFE_ID = "CAFE_ID"
        const val CAFE_STARBUCKS = 1
        const val CAFE_JANJIJIWA = 2
        const val CAFE_KOPIKENANGAN = 3

        fun newInstance(cafeId: Int) = CafeDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(CAFE_ID, cafeId)
            }
        }
    }
}