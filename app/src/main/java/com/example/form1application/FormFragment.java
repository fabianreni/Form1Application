package com.example.form1application;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FormFragment extends Fragment
{       Button country;
    Spinner countryList;
    Spinner technis;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_form, container, false);
        countryList=v.findViewById(R.id.location);
        country = v.findViewById(R.id.b_location);
        technis = v.findViewById(R.id.department);
        country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getCountryList();
            }
        });
        addTechnis();
        //setDepartmentSpinner(v);

        return v;
    }
    public void getCountryList() {
        Locale[] locale = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<>();
        String country;
        for (Locale loc : locale) {
            country = loc.getDisplayCountry();
            if (country.length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
            Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, countries);
            //Setting the ArrayAdapter data on the Spinner
            countryList.setAdapter(adapter);
        }
    }

    public void addTechnis() {

        List<String> list = new ArrayList<String>();
        list.add("Select Technis");
        list.add("Informatika");
        list.add("Automatizalas");
        list.add("Fordito");
        list.add("Kozeg");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        technis.setAdapter(dataAdapter);
    }
//    public void setDepartmentSpinner(View v)
//    {
//        Spinner departmentspinner=(Spinner) v.findViewById(R.id.department);
//
//        List<String> departments = new ArrayList<String>();
//        departments.add("Your department");
//        departments.add("Agricultural Engineering");
//        departments.add("Automation and applied informatics");
//        departments.add("Communication and public relations");
//        departments.add("Computer science");
//        departments.add("Computer-aided operation planning");
//        departments.add("Horticultural engineering");
//        departments.add("Information science");
//        departments.add("Landscape architecture");
//        departments.add("Mechatronics");
//        departments.add("Public Health Services and Policies");
//        departments.add("Telecommunication");
//        departments.add("Translation and interpreting studies");
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, departments)
//        {
//            @Override
//            public boolean isEnabled(int position)
//            {
//                if(position == 0)
//                {
//                    return false;
//                }
//
//                return true;
//            }
//
//            @Override
//            public View getDropDownView(int position, View convertView, ViewGroup parent)
//            {
//                View view = super.getDropDownView(position, convertView, parent);
//                TextView tv = (TextView) view;
//
//                if(position == 0)
//                {
//                    tv.setTextColor(Color.GRAY);
//                }
//                else
//                {
//                    tv.setTextColor(Color.BLACK);
//                }
//
//                return view;
//            }
//        };
//
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        departmentspinner.setAdapter(dataAdapter);
//    }
}
