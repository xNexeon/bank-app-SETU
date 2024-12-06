package org.setu
import Screens

class AdministratorPanel {

    private val bankScreens = Screens()

    // Runs the admin panel
    fun runAdminPanel() {
        showPanel()


    }

    //show admin panel
    fun showPanel () {
        bankScreens.adminScreen()
    }
}