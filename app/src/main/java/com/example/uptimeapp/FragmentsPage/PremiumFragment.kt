package com.example.uptimeapp.FragmentsPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.uptimeapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_forpremiumplans.*
import kotlinx.android.synthetic.main.fragment_premium.*

class PremiumFragment : Fragment(R.layout.fragment_premium) {
    private var bottomSheetBehavior: BottomSheetBehavior<*>? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet_premiumPlans)

        btnViewAllPlans.setOnClickListener {
            (bottomSheetBehavior as BottomSheetBehavior<*>).setState(
                BottomSheetBehavior.STATE_EXPANDED
            )
        }

    }
}