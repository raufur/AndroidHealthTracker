/*
 * Copyright 2009 Dan Morrill
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package coders.epsilon.com.androidhealthtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WeightTracker extends DataCollectorBaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weight_tracker);

		final EditText weight = (EditText) findViewById(R.id.weight);
		((Button) findViewById(R.id.save_button))
				.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						// TODO: build in ability to switch between SI &
						// Imperial units
						try {
							if (dbUtil.addImperialWeightRecord(Integer
									.parseInt(weight.getText().toString()))) {
								finish();
							} else {
								displayErrorDialog(R.string.weight_error, false);
							}
						} catch (NumberFormatException ex) {
							displayErrorDialog(R.string.weight_error, false);
						}
					}
				});

		((Button) findViewById(R.id.cancel_button))
				.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						finish();
					}
				});
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
