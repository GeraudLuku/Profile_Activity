package com.example.profileactivity;

import android.content.Context;
import android.util.Log;

import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CountryToPhonePrefix {

    private final Context context;
    private PhoneNumberUtil phoneNumberUtil;

    public CountryToPhonePrefix(Context context) {
        this.context = context;
        phoneNumberUtil = PhoneNumberUtil.createInstance(context);
    }

     String getCountryIsoCode(String number) {

        String validatedNumber = (number.startsWith("+")) ? number : "+" + number;
        Phonenumber.PhoneNumber phoneNumber = null;

        try {
            phoneNumber = phoneNumberUtil.parse(validatedNumber, null);
        } catch (NumberParseException e) {
            e.printStackTrace();
        }

        if (phoneNumber == null) return null;

        return phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode());
    }
}
