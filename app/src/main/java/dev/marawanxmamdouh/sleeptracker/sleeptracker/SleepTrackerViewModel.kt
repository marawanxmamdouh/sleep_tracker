package dev.marawanxmamdouh.sleeptracker.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import dev.marawanxmamdouh.sleeptracker.database.SleepDatabaseDao
import dev.marawanxmamdouh.sleeptracker.database.SleepNight
import dev.marawanxmamdouh.sleeptracker.formatNights
import kotlinx.coroutines.launch

class SleepTrackerViewModel(
    val database: SleepDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

}

