// Fragment1.kt (Mentor RSVP)
package com.igdtuw.ceramify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import com.igdtuw.ceramify.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val genderOptions = listOf("Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, genderOptions)
        binding.menteeGenderAutoComplete.setAdapter(genderAdapter)
        binding.menteeGenderAutoComplete.threshold = 0
        binding.menteeGenderAutoComplete.setOnClickListener {
            binding.menteeGenderAutoComplete.showDropDown()
        }

        binding.backArrow.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        val workshopName = arguments?.getString("workshopName") ?: "Workshop"
        binding.workshopHeading.text = "RSVP for $workshopName \nas Mentor"

        binding.menteeSubmit.setOnClickListener {
            val name = binding.menteeName.editText?.text.toString().trim()
            val email = binding.menteeEmail.editText?.text.toString().trim()
            val phone = binding.menteePhone.editText?.text.toString().trim()
            val gender = binding.menteeGenderAutoComplete.text.toString().trim()
            val profession = binding.professionTextInputLayout.editText?.text.toString().trim()
            val institution = binding.menteeInstitution.editText?.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val db = FirebaseFirestore.getInstance()
            val mentorData = hashMapOf(
                "name" to name,
                "email" to email,
                "phone" to phone,
                "gender" to gender,
                "profession" to profession,
                "institution" to institution,
                "role" to "Mentor"
            )

            db.collection("workshops").document(workshopName)
                .collection("rsvps").add(mentorData)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "RSVP submitted successfully!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), "Failed to submit RSVP.", Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}