package com.example.deagle.ui.kelas.detail

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deagle.R
import com.example.deagle.data.DataSource
import com.example.deagle.data.DeagleClassMaterial
import com.example.deagle.databinding.FragmentClassMaterialBinding
import com.example.deagle.ui.kelas.detail.adapter.ClassMaterialRecyclerAdapter

const val ARG_OBJECT = "object"


class ClassMaterialFragment : Fragment(), ClassMaterialRecyclerAdapter.OnItemClickCallback {

    private var _binding: FragmentClassMaterialBinding? = null
    private val binding get() =  _binding!!
    private lateinit var classMaterialRecyclerAdapter: ClassMaterialRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentClassMaterialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            classMaterialRecyclerAdapter = ClassMaterialRecyclerAdapter(this@ClassMaterialFragment)
            classMaterialRecyclerAdapter.setData(data = DataSource.classMaterials)
            classMaterialRv.layoutManager = LinearLayoutManager(requireActivity().applicationContext, RecyclerView.VERTICAL, false)
            classMaterialRv.hasFixedSize()
            classMaterialRv.adapter = classMaterialRecyclerAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun clickable(deagleClassMaterial: DeagleClassMaterial) {
        val bundle = Bundle()
        bundle.apply {
            putString(DCM_TITLE_KEY, deagleClassMaterial.title)
            putString(DCM_DESC_KEY, deagleClassMaterial.description)
            putString(DCM_TYPE_KEY, deagleClassMaterial.type)
            putString(DCM_WORKING_TIME_KEY, deagleClassMaterial.workingTime)
            putString(DCM_DEADLINE_KEY, deagleClassMaterial.deadline)
            putBoolean(DCM_IS_FINISHED_KEY, deagleClassMaterial.isFinished)
            deagleClassMaterial.statusIcon?.let { putInt(DCM_STATUS_ICON_KEY, it) }
            putString(DCM_FINISHED_DATE_KEY, deagleClassMaterial.finishDate)
        }

        val classTaskFragment = ClassTaskFragment()
        classTaskFragment.arguments = bundle
        val fragmentManager = parentFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.class_detail_frame_container, classTaskFragment, ClassTaskFragment::class.java.simpleName)
            .addToBackStack(null)
            .commit()
    }
}