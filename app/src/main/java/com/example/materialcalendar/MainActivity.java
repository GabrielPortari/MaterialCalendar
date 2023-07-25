package com.example.materialcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class MainActivity extends AppCompatActivity {
    private MaterialCalendarView materialCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialCalendarView = findViewById(R.id.calendarView);

        //Setagem de data mínima e máxima
        materialCalendarView.state().edit()
                //.setMinimumDate(CalendarDay.from(2021, 2, 2))
                //.setMaximumDate(CalendarDay.from(2025,12,31))
                .commit();

        //CharSequence meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        CharSequence meses[] = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        materialCalendarView.setTitleMonths(meses);
        //CharSequence dias[] = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo"};
        CharSequence dias[] = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom"};
        materialCalendarView.setWeekDayLabels(dias);

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Log.i("INFO CALENDARVIEW", "Data: " + date); // Navegaçao entre datas
            }
        });

        materialCalendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                Log.i("INFO CALENDARVIEW", "Mes: " + date.getMonth()); // Navegaçao entre meses
                Log.i("INFO CALENDARVIEW", "Mes/Ano: " + date.getMonth() + "/" + date.getYear()); // Navegaçao entre meses/anos
            }
        });

    }
}