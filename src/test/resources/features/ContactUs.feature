Feature: Contact Us
  As a user, I want to view Datacom's office locations so that I can the address, map locations, contact no and email
  As a user, i want to contact Datacom so that I can send inquiries and feedback to them

  Scenario Outline: CONTACTUS-001: Verify office location details of Datacom
    Given I visit contact us page
    When I visit "<region>" tab and "<city>" dropdown
    Then I see the correct office location details for "<city>" "<region>"

    Examples:
      | region      | city         |
      | New Zealand | Auckland     |
      | New Zealand | Christchurch |
      | New Zealand | Dunedin      |
      | Australia   | Canberra     |
      | Australia   | Melbourne    |
      | Australia   | Perth        |
      | Asia        | Malaysia     |
      | Asia        | Philippines  |
      | Asia        | Singapore    |