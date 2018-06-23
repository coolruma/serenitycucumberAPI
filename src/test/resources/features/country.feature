Feature: xxx

	Scenario: Get geocode for Amphitheatre Parkway
		Given I have an address 1600 Amphitheatre Parkway, Mountain View, CA
		When I request google api for geocode with address
		Then I should get response status code 200
		And I should get longitude -122.08427 and latitude 37.422348