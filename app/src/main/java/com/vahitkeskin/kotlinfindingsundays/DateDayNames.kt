package com.vahitkeskin.kotlinfindingsundays

class DateDayNames {

    var dd = 0
    var mm = 0
    var yyyy = 0
    fun DateDayNames(dd: Int, mm: Int, yyyy: Int) {
        this.dd = dd
        this.mm = mm
        this.yyyy = yyyy
    }

    private fun checkLeap(y: Int): Int {
        return if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) 1 else 0
    }

    fun calculate(): String {

        val flag_for_leap = checkLeap(yyyy)

        val day = arrayOf(
            "Pazar", "Pazartesi", "Salı",
            "Çarşamba", "Perşembe", "Cuma",
            "Cumartesi"
        )
        val m_no = intArrayOf(0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5)

        val j: Int
        j = if (yyyy / 100 % 2 == 0) {
            if (yyyy / 100 % 4 == 0) 6 else 2
        } else {
            if ((yyyy / 100 - 1) % 4 == 0) 4 else 0
        }

        val total = (yyyy % 100 + yyyy % 100 / 4 + dd
                + m_no[mm - 1] + j)
        if (flag_for_leap == 1) {
            if (total % 7 > 0) return day[total % 7 - 1] else return day[6]
        } else return day[total % 7]
    }
}