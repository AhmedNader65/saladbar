package com.example.saladbar.ui.slot

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.Insets
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.saladbar.databinding.FragmentSlotBinding


class SlotDialogFragment : DialogFragment() {
    private var _binding: FragmentSlotBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentSlotBinding.inflate(LayoutInflater.from(context))
        binding.num0.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("0")
        }
        binding.num1.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("1")
        }
        binding.num2.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("2")
        }
        binding.num3.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("3")
        }
        binding.num4.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("4")
        }
        binding.num5.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("5")
        }
        binding.num6.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("6")
        }
        binding.num7.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("7")
        }
        binding.num8.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("8")
        }
        binding.num9.setOnClickListener {
            binding.slotNumET.text = binding.slotNumET.text.append("9")
        }
        binding.delete.setOnClickListener {
            if (binding.slotNumET.text.isNotEmpty())
            binding.slotNumET.text = binding.slotNumET.text.delete(binding.slotNumET.text.length-1,binding.slotNumET.text.length)
        }
        binding.cancel.setOnClickListener {
            this.dismiss()
        }
        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()

    }

    override fun onResume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics =
                requireActivity().windowManager.currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            val width = windowMetrics.bounds.width() - insets.left -
                    insets.right
            val height = windowMetrics.bounds.height() - insets.top -
                    insets.bottom
            val window = dialog!!.window
            if (window != null) {
                window.setLayout((width * 0.90).toInt(), (height *
                        0.90).toInt()) // for width and height to be 90 % of screen
                window.setGravity(Gravity.CENTER)
            }
            super.onResume()
        } else {
            val window = dialog!!.window
            val size = Point()
            // Store dimensions of the screen in `size`
            val display = window!!.windowManager.defaultDisplay
            display.getSize(size)
            // Set the width of the dialog proportional to 90% of the screen width
            window.setLayout((size.x * 0.90).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT)
            window.setGravity(Gravity.CENTER)
            // Call super onResume after sizing
            super.onResume()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (dialog != null && dialog?.window != null) {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE);
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}