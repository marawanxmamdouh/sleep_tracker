package dev.marawanxmamdouh.sleeptracker.sleeptracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.marawanxmamdouh.sleeptracker.R
import dev.marawanxmamdouh.sleeptracker.database.SleepDatabase
import dev.marawanxmamdouh.sleeptracker.databinding.FragmentSleepTrackerBinding


class SleepTrackerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentSleepTrackerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sleep_tracker, container, false
        )

        // get the application context
        val application = requireNotNull(this.activity).application

        // Create an instance of the DAO to access the database.
        val dataSource = SleepDatabase.getInstance(application).sleepDatabaseDao

        // Create an instance of the ViewModel Factory.
        val viewModelFactory = SleepTrackerViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val sleepTrackerViewModel =
            ViewModelProvider(
                this, viewModelFactory
            )[SleepTrackerViewModel::class.java]

        // Use the View Model with data binding
        binding.sleepTrackerViewModel = sleepTrackerViewModel

        // Specify the current activity as the lifecycle owner of the binding.
        binding.lifecycleOwner = this

        return binding.root
    }
}
