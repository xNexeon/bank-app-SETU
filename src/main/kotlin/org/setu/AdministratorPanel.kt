package org.setu
import Screens

class AdministratorPanel {

    private val bankScreens = Screens()

    fun runAdminPanel() {
        showPanel()


    }

    fun showPanel () {
        bankScreens.adminScreen()
    }
}