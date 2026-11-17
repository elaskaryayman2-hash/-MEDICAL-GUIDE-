package com.example.medicalguide

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. تفعيل خانة البحث العلوي الشامل
        val searchView = findViewById<SearchView>(R.id.searchViewGlobal)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            onQueryTextSubmit(query: String?): Boolean {
                // تنفيذ البحث الشامل عن الطبيب أو المستشفى
                Toast.parse(this@MainActivity, "جاري البحث عن: $query", Toast.LENGTH_SHORT).show()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean = false
        })

        // 3. ابحث عن طبيب (الموقع الجغرافي، المواعيد، الحجز، وأرقام التليفونات)
        findViewById<CardView>(R.id.cardFindDoctor).setOnClickListener {
            // فتح خريطة أو شاشة الأطباء القريبين باستخدام الـ GPS
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=أقرب طبيب"))
            startActivity(intent)
        }

        // 2 & 4. عيادات ومستشفيات / صيدليات (تحديد أقرب موقع جغرافي)
        findViewById<CardView>(R.id.cardClinics).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=مستشفيات وعيادات قريبة"))
            startActivity(intent)
        }
        findViewById<CardView>(R.id.cardPharmacies).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=صيدلية قريبة"))
            startActivity(intent)
        }

        // 5. الطوارئ (أرقام الخدمة والاتصال المباشر بضغطة زر)
        findViewById<CardView>(R.id.cardEmergency).setOnClickListener {
            val emergencyNumber = "tel:123" // رقم الإسعاف والطوارئ التجريبي
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse(emergencyNumber))
            startActivity(callIntent)
        }

        // 7. تاريخي الطبي (إرفاق اسم الطبيب وإظهار التفاصيل الطبية)
        findViewById<CardView>(R.id.cardMedicalHistory).setOnClickListener {
            Toast.makeText(this, "فتح السجل الطبي وإدخال اسم الطبيب للبحث", Toast.LENGTH_LONG).show()
            // هنا يتم توجيه المستخدم لشاشة الملف الطبي والوصفات السابقة
        }

        // 6. الإشعارات (تنبيه الاقتراب الجغرافي بجرس خفيف)
        findViewById<CardView>(R.id.cardNotifications).setOnClickListener {
            Toast.makeText(this, "التنبيهات مفعلة: ستتلقى جرساً خفيفاً عند الاقتراب من منشأة طبية", Toast.LENGTH_LONG).show()
        }

        // تفعيل شريط التنقل السفلي (الرئيسية، البحث، الحجوزات، الإعدادات)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "الرئيسية", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_search -> {
                    searchView.isIconified = false // فتح خانة البحث مباشرة
                    true
                }
                R.id.nav_bookings -> {
                    Toast.makeText(this, "فتح شاشة الحجوزات والمواعيد", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_settings -> {
                    Toast.makeText(this, "فتح إعدادات اللغة (عربي / إنجليزي)", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
package com.example.medicalguide

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. تفعيل خانة البحث العلوي الشامل
        val searchView = findViewById<SearchView>(R.id.searchViewGlobal)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            onQueryTextSubmit(query: String?): Boolean {
                // تنفيذ البحث الشامل عن الطبيب أو المستشفى
                Toast.parse(this@MainActivity, "جاري البحث عن: $query", Toast.LENGTH_SHORT).show()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean = false
        })

        // 3. ابحث عن طبيب (الموقع الجغرافي، المواعيد، الحجز، وأرقام التليفونات)
        findViewById<CardView>(R.id.cardFindDoctor).setOnClickListener {
            // فتح خريطة أو شاشة الأطباء القريبين باستخدام الـ GPS
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=أقرب طبيب"))
            startActivity(intent)
        }

        // 2 & 4. عيادات ومستشفيات / صيدليات (تحديد أقرب موقع جغرافي)
        findViewById<CardView>(R.id.cardClinics).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=مستشفيات وعيادات قريبة"))
            startActivity(intent)
        }
        findViewById<CardView>(R.id.cardPharmacies).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=صيدلية قريبة"))
            startActivity(intent)
        }

        // 5. الطوارئ (أرقام الخدمة والاتصال المباشر بضغطة زر)
        findViewById<CardView>(R.id.cardEmergency).setOnClickListener {
            val emergencyNumber = "tel:123" // رقم الإسعاف والطوارئ التجريبي
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse(emergencyNumber))
            startActivity(callIntent)
        }

        // 7. تاريخي الطبي (إرفاق اسم الطبيب وإظهار التفاصيل الطبية)
        findViewById<CardView>(R.id.cardMedicalHistory).setOnClickListener {
            Toast.makeText(this, "فتح السجل الطبي وإدخال اسم الطبيب للبحث", Toast.LENGTH_LONG).show()
            // هنا يتم توجيه المستخدم لشاشة الملف الطبي والوصفات السابقة
        }

        // 6. الإشعارات (تنبيه الاقتراب الجغرافي بجرس خفيف)
        findViewById<CardView>(R.id.cardNotifications).setOnClickListener {
            Toast.makeText(this, "التنبيهات مفعلة: ستتلقى جرساً خفيفاً عند الاقتراب من منشأة طبية", Toast.LENGTH_LONG).show()
        }

        // تفعيل شريط التنقل السفلي (الرئيسية، البحث، الحجوزات، الإعدادات)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "الرئيسية", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_search -> {
                    searchView.isIconified = false // فتح خانة البحث مباشرة
                    true
                }
                R.id.nav_bookings -> {
                    Toast.makeText(this, "فتح شاشة الحجوزات والمواعيد", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_settings -> {
                    Toast.makeText(this, "فتح إعدادات اللغة (عربي / إنجليزي)", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
