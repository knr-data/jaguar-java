// File generated from our OpenAPI spec
package com.jaguar.functional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jaguar.BaseJaguarTest;
import com.jaguar.exception.JaguarException;
import com.jaguar.model.*;
import com.jaguar.net.ApiResource;
import com.jaguar.param.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class GeneratedExamples extends BaseJaguarTest {
  @Test
  public void testCustomerList() throws JaguarException {
    CustomerListParams params = CustomerListParams.builder().setLimit(3L).build();

    CustomerCollection customers = Customer.list(params);
    assertNotNull(customers);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/customers", params.toMap());
  }

  @Test
  public void testBalanceTransactionRetrieve() throws JaguarException {
    BalanceTransaction balanceTransaction = BalanceTransaction.retrieve("txn_xxxxxxxxxxxxx");
    assertNotNull(balanceTransaction);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/balance_transactions/txn_xxxxxxxxxxxxx");
  }

  @Test
  public void testBalanceTransactionList() throws JaguarException {
    BalanceTransactionListParams params =
        BalanceTransactionListParams.builder().setLimit(3L).build();

    BalanceTransactionCollection balanceTransactions = BalanceTransaction.list(params);
    assertNotNull(balanceTransactions);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/balance_transactions", params.toMap());
  }

  @Test
  public void testChargeCreate() throws JaguarException {
    ChargeCreateParams params =
        ChargeCreateParams.builder()
            .setAmount(2000L)
            .setCurrency("usd")
            .setSource("tok_xxxx")
            .setDescription("My First Test Charge (created for API docs)")
            .build();

    Charge charge = Charge.create(params);
    assertNotNull(charge);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/charges", params.toMap());
  }

  @Test
  public void testChargeRetrieve() throws JaguarException {
    Charge charge = Charge.retrieve("ch_xxxxxxxxxxxxx");
    assertNotNull(charge);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/charges/ch_xxxxxxxxxxxxx");
  }

  @Test
  public void testChargeUpdate() throws JaguarException {
    Charge resource = Charge.retrieve("ch_xxxxxxxxxxxxx");
    ChargeUpdateParams params =
        ChargeUpdateParams.builder().putMetadata("order_id", "6735").build();

    Charge charge = resource.update(params);
    assertNotNull(charge);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/charges/ch_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testChargeCapture() throws JaguarException {
    Charge resource = Charge.retrieve("ch_xxxxxxxxxxxxx");
    ChargeCaptureParams params = ChargeCaptureParams.builder().build();

    Charge charge = resource.capture(params);
    assertNotNull(charge);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/charges/ch_xxxxxxxxxxxxx/capture", params.toMap());
  }

  @Test
  public void testChargeList() throws JaguarException {
    ChargeListParams params = ChargeListParams.builder().setLimit(3L).build();

    ChargeCollection charges = Charge.list(params);
    assertNotNull(charges);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/charges", params.toMap());
  }

  @Test
  public void testCustomerCreate() throws JaguarException {
    CustomerCreateParams params =
        CustomerCreateParams.builder()
            .setDescription("My First Test Customer (created for API docs)")
            .build();

    Customer customer = Customer.create(params);
    assertNotNull(customer);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/customers", params.toMap());
  }

  @Test
  public void testCustomerRetrieve() throws JaguarException {
    Customer customer = Customer.retrieve("cus_xxxxxxxxxxxxx");
    assertNotNull(customer);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/customers/cus_xxxxxxxxxxxxx");
  }

  @Test
  public void testCustomerUpdate() throws JaguarException {
    Customer resource = Customer.retrieve("cus_xxxxxxxxxxxxx");
    CustomerUpdateParams params =
        CustomerUpdateParams.builder().putMetadata("order_id", "6735").build();

    Customer customer = resource.update(params);
    assertNotNull(customer);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/customers/cus_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testCustomerDelete() throws JaguarException {
    Customer resource = Customer.retrieve("cus_xxxxxxxxxxxxx");

    Customer customer = resource.delete();
    assertNotNull(customer);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/customers/cus_xxxxxxxxxxxxx");
  }

  @Test
  public void testCustomerList2() throws JaguarException {
    CustomerListParams params = CustomerListParams.builder().setLimit(3L).build();

    CustomerCollection customers = Customer.list(params);
    assertNotNull(customers);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/customers", params.toMap());
  }

  @Test
  public void testDisputeRetrieve() throws JaguarException {
    Dispute dispute = Dispute.retrieve("dp_xxxxxxxxxxxxx");
    assertNotNull(dispute);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/disputes/dp_xxxxxxxxxxxxx");
  }

  @Test
  public void testDisputeUpdate() throws JaguarException {
    Dispute resource = Dispute.retrieve("dp_xxxxxxxxxxxxx");
    DisputeUpdateParams params =
        DisputeUpdateParams.builder().putMetadata("order_id", "6735").build();

    Dispute dispute = resource.update(params);
    assertNotNull(dispute);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/disputes/dp_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testDisputeClose() throws JaguarException {
    Dispute resource = Dispute.retrieve("dp_xxxxxxxxxxxxx");
    DisputeCloseParams params = DisputeCloseParams.builder().build();

    Dispute dispute = resource.close(params);
    assertNotNull(dispute);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/disputes/dp_xxxxxxxxxxxxx/close", params.toMap());
  }

  @Test
  public void testDisputeList() throws JaguarException {
    DisputeListParams params = DisputeListParams.builder().setLimit(3L).build();

    DisputeCollection disputes = Dispute.list(params);
    assertNotNull(disputes);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/disputes", params.toMap());
  }

  @Test
  public void testEventRetrieve() throws JaguarException {
    Event event = Event.retrieve("evt_xxxxxxxxxxxxx");
    assertNotNull(event);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/events/evt_xxxxxxxxxxxxx");
  }

  @Test
  public void testEventList() throws JaguarException {
    EventListParams params = EventListParams.builder().setLimit(3L).build();

    EventCollection events = Event.list(params);
    assertNotNull(events);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/events", params.toMap());
  }

  @Test
  public void testFileLinkCreate() throws JaguarException {
    FileLinkCreateParams params =
        FileLinkCreateParams.builder().setFile("file_xxxxxxxxxxxxx").build();

    FileLink fileLink = FileLink.create(params);
    assertNotNull(fileLink);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/file_links", params.toMap());
  }

  @Test
  public void testFileLinkRetrieve() throws JaguarException {
    FileLink fileLink = FileLink.retrieve("link_xxxxxxxxxxxxx");
    assertNotNull(fileLink);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/file_links/link_xxxxxxxxxxxxx");
  }

  @Test
  public void testFileLinkUpdate() throws JaguarException {
    FileLink resource = FileLink.retrieve("link_xxxxxxxxxxxxx");
    FileLinkUpdateParams params =
        FileLinkUpdateParams.builder().putMetadata("order_id", "6735").build();

    FileLink fileLink = resource.update(params);
    assertNotNull(fileLink);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/file_links/link_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testFileLinkList() throws JaguarException {
    FileLinkListParams params = FileLinkListParams.builder().setLimit(3L).build();

    FileLinkCollection fileLinks = FileLink.list(params);
    assertNotNull(fileLinks);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/file_links", params.toMap());
  }

  @Test
  public void testMandateRetrieve() throws JaguarException {
    Mandate mandate = Mandate.retrieve("mandate_xxxxxxxxxxxxx");
    assertNotNull(mandate);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/mandates/mandate_xxxxxxxxxxxxx");
  }

  @Test
  public void testPaymentIntentCreate() throws JaguarException {
    PaymentIntentCreateParams params =
        PaymentIntentCreateParams.builder()
            .setAmount(2000L)
            .setCurrency("usd")
            .addPaymentMethodType("card")
            .build();

    PaymentIntent paymentIntent = PaymentIntent.create(params);
    assertNotNull(paymentIntent);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/payment_intents", params.toMap());
  }

  @Test
  public void testPaymentIntentRetrieve() throws JaguarException {
    PaymentIntent paymentIntent = PaymentIntent.retrieve("pi_xxxxxxxxxxxxx");
    assertNotNull(paymentIntent);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/payment_intents/pi_xxxxxxxxxxxxx");
  }

  @Test
  public void testPaymentIntentUpdate() throws JaguarException {
    PaymentIntent resource = PaymentIntent.retrieve("pi_xxxxxxxxxxxxx");
    PaymentIntentUpdateParams params =
        PaymentIntentUpdateParams.builder().putMetadata("order_id", "6735").build();

    PaymentIntent paymentIntent = resource.update(params);
    assertNotNull(paymentIntent);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/payment_intents/pi_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testPaymentIntentConfirm() throws JaguarException {
    PaymentIntent resource = PaymentIntent.retrieve("pi_xxxxxxxxxxxxx");
    PaymentIntentConfirmParams params =
        PaymentIntentConfirmParams.builder().setPaymentMethod("pm_card_visa").build();

    PaymentIntent paymentIntent = resource.confirm(params);
    assertNotNull(paymentIntent);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/payment_intents/pi_xxxxxxxxxxxxx/confirm",
        params.toMap());
  }

  @Test
  public void testPaymentIntentCapture() throws JaguarException {
    PaymentIntent resource = PaymentIntent.retrieve("pi_xxxxxxxxxxxxx");
    PaymentIntentCaptureParams params = PaymentIntentCaptureParams.builder().build();

    PaymentIntent paymentIntent = resource.capture(params);
    assertNotNull(paymentIntent);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/payment_intents/pi_xxxxxxxxxxxxx/capture",
        params.toMap());
  }

  @Test
  public void testPaymentIntentCancel() throws JaguarException {
    PaymentIntent resource = PaymentIntent.retrieve("pi_xxxxxxxxxxxxx");
    PaymentIntentCancelParams params = PaymentIntentCancelParams.builder().build();

    PaymentIntent paymentIntent = resource.cancel(params);
    assertNotNull(paymentIntent);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/payment_intents/pi_xxxxxxxxxxxxx/cancel",
        params.toMap());
  }

  @Test
  public void testPaymentIntentList() throws JaguarException {
    PaymentIntentListParams params = PaymentIntentListParams.builder().setLimit(3L).build();

    PaymentIntentCollection paymentIntents = PaymentIntent.list(params);
    assertNotNull(paymentIntents);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/payment_intents", params.toMap());
  }

  @Test
  public void testSetupIntentCreate() throws JaguarException {
    SetupIntentCreateParams params =
        SetupIntentCreateParams.builder().addPaymentMethodType("card").build();

    SetupIntent setupIntent = SetupIntent.create(params);
    assertNotNull(setupIntent);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/setup_intents", params.toMap());
  }

  @Test
  public void testSetupIntentRetrieve() throws JaguarException {
    SetupIntent setupIntent = SetupIntent.retrieve("seti_xxxxxxxxxxxxx");
    assertNotNull(setupIntent);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/setup_intents/seti_xxxxxxxxxxxxx");
  }

  @Test
  public void testSetupIntentUpdate() throws JaguarException {
    SetupIntent resource = SetupIntent.retrieve("seti_xxxxxxxxxxxxx");
    SetupIntentUpdateParams params =
        SetupIntentUpdateParams.builder().putMetadata("user_id", "3435453").build();

    SetupIntent setupIntent = resource.update(params);
    assertNotNull(setupIntent);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/setup_intents/seti_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testSetupIntentConfirm() throws JaguarException {
    SetupIntent resource = SetupIntent.retrieve("seti_xxxxxxxxxxxxx");
    SetupIntentConfirmParams params =
        SetupIntentConfirmParams.builder().setPaymentMethod("pm_card_visa").build();

    SetupIntent setupIntent = resource.confirm(params);
    assertNotNull(setupIntent);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/setup_intents/seti_xxxxxxxxxxxxx/confirm",
        params.toMap());
  }

  @Test
  public void testSetupIntentCancel() throws JaguarException {
    SetupIntent resource = SetupIntent.retrieve("seti_xxxxxxxxxxxxx");
    SetupIntentCancelParams params = SetupIntentCancelParams.builder().build();

    SetupIntent setupIntent = resource.cancel(params);
    assertNotNull(setupIntent);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/setup_intents/seti_xxxxxxxxxxxxx/cancel",
        params.toMap());
  }

  @Test
  public void testSetupIntentList() throws JaguarException {
    SetupIntentListParams params = SetupIntentListParams.builder().setLimit(3L).build();

    SetupIntentCollection setupIntents = SetupIntent.list(params);
    assertNotNull(setupIntents);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/setup_intents", params.toMap());
  }

  @Test
  public void testSetupAttemptList() throws JaguarException {
    SetupAttemptListParams params =
        SetupAttemptListParams.builder().setSetupIntent("seti_xxxxxxxxxxxxx").setLimit(3L).build();

    SetupAttemptCollection setupAttempts = SetupAttempt.list(params);
    assertNotNull(setupAttempts);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/setup_attempts", params.toMap());
  }

  @Test
  public void testPayoutCreate() throws JaguarException {
    PayoutCreateParams params =
        PayoutCreateParams.builder().setAmount(1100L).setCurrency("usd").build();

    Payout payout = Payout.create(params);
    assertNotNull(payout);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/payouts", params.toMap());
  }

  @Test
  public void testPayoutRetrieve() throws JaguarException {
    Payout payout = Payout.retrieve("po_xxxxxxxxxxxxx");
    assertNotNull(payout);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/payouts/po_xxxxxxxxxxxxx");
  }

  @Test
  public void testPayoutUpdate() throws JaguarException {
    Payout resource = Payout.retrieve("po_xxxxxxxxxxxxx");
    PayoutUpdateParams params =
        PayoutUpdateParams.builder().putMetadata("order_id", "6735").build();

    Payout payout = resource.update(params);
    assertNotNull(payout);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/payouts/po_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testPayoutList() throws JaguarException {
    PayoutListParams params = PayoutListParams.builder().setLimit(3L).build();

    PayoutCollection payouts = Payout.list(params);
    assertNotNull(payouts);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/payouts", params.toMap());
  }

  @Test
  public void testPayoutCancel() throws JaguarException {
    Payout resource = Payout.retrieve("po_xxxxxxxxxxxxx");
    PayoutCancelParams params = PayoutCancelParams.builder().build();

    Payout payout = resource.cancel(params);
    assertNotNull(payout);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/payouts/po_xxxxxxxxxxxxx/cancel", params.toMap());
  }

  @Test
  public void testPayoutReverse() throws JaguarException {
    Payout resource = Payout.retrieve("po_xxxxxxxxxxxxx");
    PayoutReverseParams params = PayoutReverseParams.builder().build();

    Payout payout = resource.reverse(params);
    assertNotNull(payout);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/payouts/po_xxxxxxxxxxxxx/reverse", params.toMap());
  }

  @Test
  public void testProductCreate() throws JaguarException {
    ProductCreateParams params = ProductCreateParams.builder().setName("Gold Special").build();

    Product product = Product.create(params);
    assertNotNull(product);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/products", params.toMap());
  }

  @Test
  public void testProductRetrieve() throws JaguarException {
    Product product = Product.retrieve("prod_xxxxxxxxxxxxx");
    assertNotNull(product);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/products/prod_xxxxxxxxxxxxx");
  }

  @Test
  public void testProductUpdate() throws JaguarException {
    Product resource = Product.retrieve("prod_xxxxxxxxxxxxx");
    ProductUpdateParams params =
        ProductUpdateParams.builder().putMetadata("order_id", "6735").build();

    Product product = resource.update(params);
    assertNotNull(product);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/products/prod_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testProductList() throws JaguarException {
    ProductListParams params = ProductListParams.builder().setLimit(3L).build();

    ProductCollection products = Product.list(params);
    assertNotNull(products);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/products", params.toMap());
  }

  @Test
  public void testProductDelete() throws JaguarException {
    Product resource = Product.retrieve("prod_xxxxxxxxxxxxx");

    Product product = resource.delete();
    assertNotNull(product);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/products/prod_xxxxxxxxxxxxx");
  }

  @Test
  public void testPriceCreate() throws JaguarException {
    PriceCreateParams params =
        PriceCreateParams.builder()
            .setUnitAmount(2000L)
            .setCurrency("usd")
            .setRecurring(
                PriceCreateParams.Recurring.builder()
                    .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                    .build())
            .setProduct("prod_xxxxxxxxxxxxx")
            .build();

    Price price = Price.create(params);
    assertNotNull(price);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/prices", params.toMap());
  }

  @Test
  public void testPriceRetrieve() throws JaguarException {
    Price price = Price.retrieve("price_xxxxxxxxxxxxx");
    assertNotNull(price);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/prices/price_xxxxxxxxxxxxx");
  }

  @Test
  public void testPriceUpdate() throws JaguarException {
    Price resource = Price.retrieve("price_xxxxxxxxxxxxx");
    PriceUpdateParams params = PriceUpdateParams.builder().putMetadata("order_id", "6735").build();

    Price price = resource.update(params);
    assertNotNull(price);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/prices/price_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testPriceList() throws JaguarException {
    PriceListParams params = PriceListParams.builder().setLimit(3L).build();

    PriceCollection prices = Price.list(params);
    assertNotNull(prices);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/prices", params.toMap());
  }

  @Test
  public void testRefundCreate() throws JaguarException {
    RefundCreateParams params = RefundCreateParams.builder().setCharge("ch_xxxxxxxxxxxxx").build();

    Refund refund = Refund.create(params);
    assertNotNull(refund);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/refunds", params.toMap());
  }

  @Test
  public void testRefundRetrieve() throws JaguarException {
    Refund refund = Refund.retrieve("re_xxxxxxxxxxxxx");
    assertNotNull(refund);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/refunds/re_xxxxxxxxxxxxx");
  }

  @Test
  public void testRefundUpdate() throws JaguarException {
    Refund resource = Refund.retrieve("re_xxxxxxxxxxxxx");
    RefundUpdateParams params =
        RefundUpdateParams.builder().putMetadata("order_id", "6735").build();

    Refund refund = resource.update(params);
    assertNotNull(refund);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/refunds/re_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testRefundList() throws JaguarException {
    RefundListParams params = RefundListParams.builder().setLimit(3L).build();

    RefundCollection refunds = Refund.list(params);
    assertNotNull(refunds);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/refunds", params.toMap());
  }

  @Test
  public void testTokenCreate() throws JaguarException {
    TokenCreateParams params =
        TokenCreateParams.builder()
            .setCard(
                TokenCreateParams.Card.builder()
                    .setNumber("4242424242424242")
                    .setExpMonth("5")
                    .setExpYear("2022")
                    .setCvc("314")
                    .build())
            .build();

    Token token = Token.create(params);
    assertNotNull(token);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/tokens", params.toMap());
  }

  @Test
  public void testTokenCreate2() throws JaguarException {
    TokenCreateParams params =
        TokenCreateParams.builder()
            .setBankAccount(
                TokenCreateParams.BankAccount.builder()
                    .setCountry("US")
                    .setCurrency("usd")
                    .setAccountHolderName("Jenny Rosen")
                    .setAccountHolderType(
                        TokenCreateParams.BankAccount.AccountHolderType.INDIVIDUAL)
                    .setRoutingNumber("110000000")
                    .setAccountNumber("000123456789")
                    .build())
            .build();

    Token token = Token.create(params);
    assertNotNull(token);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/tokens", params.toMap());
  }

  @Test
  public void testTokenCreate3() throws JaguarException {
    TokenCreateParams params =
        TokenCreateParams.builder()
            .setPii(TokenCreateParams.Pii.builder().setIdNumber("000000000").build())
            .build();

    Token token = Token.create(params);
    assertNotNull(token);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/tokens", params.toMap());
  }

  @Test
  public void testTokenCreate4() throws JaguarException {
    TokenCreateParams params =
        TokenCreateParams.builder()
            .setAccount(
                TokenCreateParams.Account.builder()
                    .setIndividual(
                        TokenCreateParams.Account.Individual.builder()
                            .setFirstName("Jane")
                            .setLastName("Doe")
                            .build())
                    .setTosShownAndAccepted(true)
                    .build())
            .build();

    Token token = Token.create(params);
    assertNotNull(token);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/tokens", params.toMap());
  }

  @Test
  public void testTokenCreate5() throws JaguarException {
    TokenCreateParams params =
        TokenCreateParams.builder()
            .setPerson(
                TokenCreateParams.Person.builder()
                    .setFirstName("Jane")
                    .setLastName("Doe")
                    .setRelationship(
                        TokenCreateParams.Person.Relationship.builder().setOwner(true).build())
                    .build())
            .build();

    Token token = Token.create(params);
    assertNotNull(token);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/tokens", params.toMap());
  }

  @Test
  public void testTokenCreate6() throws JaguarException {
    TokenCreateParams params =
        TokenCreateParams.builder()
            .setCvcUpdate(TokenCreateParams.CvcUpdate.builder().setCvc("123").build())
            .build();

    Token token = Token.create(params);
    assertNotNull(token);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/tokens", params.toMap());
  }

  @Test
  public void testTokenRetrieve() throws JaguarException {
    Token token = Token.retrieve("tok_xxxx");
    assertNotNull(token);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/tokens/tok_xxxx");
  }

  @Test
  public void testPaymentMethodRetrieve() throws JaguarException {
    PaymentMethod paymentMethod = PaymentMethod.retrieve("pm_xxxxxxxxxxxxx");
    assertNotNull(paymentMethod);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/payment_methods/pm_xxxxxxxxxxxxx");
  }

  @Test
  public void testPaymentMethodUpdate() throws JaguarException {
    PaymentMethod resource = PaymentMethod.retrieve("pm_xxxxxxxxxxxxx");
    PaymentMethodUpdateParams params =
        PaymentMethodUpdateParams.builder().putMetadata("order_id", "6735").build();

    PaymentMethod paymentMethod = resource.update(params);
    assertNotNull(paymentMethod);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/payment_methods/pm_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testPaymentMethodList() throws JaguarException {
    PaymentMethodListParams params =
        PaymentMethodListParams.builder()
            .setCustomer("cus_xxxxxxxxxxxxx")
            .setType(PaymentMethodListParams.Type.CARD)
            .build();

    PaymentMethodCollection paymentMethods = PaymentMethod.list(params);
    assertNotNull(paymentMethods);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/payment_methods", params.toMap());
  }

  @Test
  public void testPaymentMethodAttach() throws JaguarException {
    PaymentMethod resource = PaymentMethod.retrieve("pm_xxxxxxxxxxxxx");
    PaymentMethodAttachParams params =
        PaymentMethodAttachParams.builder().setCustomer("cus_xxxxxxxxxxxxx").build();

    PaymentMethod paymentMethod = resource.attach(params);
    assertNotNull(paymentMethod);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/payment_methods/pm_xxxxxxxxxxxxx/attach",
        params.toMap());
  }

  @Test
  public void testPaymentMethodDetach() throws JaguarException {
    PaymentMethod resource = PaymentMethod.retrieve("pm_xxxxxxxxxxxxx");
    PaymentMethodDetachParams params = PaymentMethodDetachParams.builder().build();

    PaymentMethod paymentMethod = resource.detach(params);
    assertNotNull(paymentMethod);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/payment_methods/pm_xxxxxxxxxxxxx/detach",
        params.toMap());
  }

  @Test
  public void testSourceRetrieve() throws JaguarException {
    Source source = Source.retrieve("src_xxxxxxxxxxxxx");
    assertNotNull(source);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/sources/src_xxxxxxxxxxxxx");
  }

  @Test
  public void testSourceUpdate() throws JaguarException {
    Source resource = Source.retrieve("src_xxxxxxxxxxxxx");
    SourceUpdateParams params =
        SourceUpdateParams.builder().putMetadata("order_id", "6735").build();

    Source source = resource.update(params);
    assertNotNull(source);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/sources/src_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testSessionCreate() throws JaguarException {
    com.jaguar.param.checkout.SessionCreateParams params =
        com.jaguar.param.checkout.SessionCreateParams.builder()
            .setSuccessUrl("https://example.com/success")
            .setCancelUrl("https://example.com/cancel")
            .addPaymentMethodType(
                com.jaguar.param.checkout.SessionCreateParams.PaymentMethodType.CARD)
            .addLineItem(
                com.jaguar.param.checkout.SessionCreateParams.LineItem.builder()
                    .setPrice("price_xxxxxxxxxxxxx")
                    .setQuantity(2L)
                    .build())
            .setMode(com.jaguar.param.checkout.SessionCreateParams.Mode.PAYMENT)
            .build();

    com.jaguar.model.checkout.Session session = com.jaguar.model.checkout.Session.create(params);
    assertNotNull(session);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/checkout/sessions", params.toMap());
  }

  @Test
  public void testSessionRetrieve() throws JaguarException {
    com.jaguar.model.checkout.Session session =
        com.jaguar.model.checkout.Session.retrieve("cs_test_xxxxxxxxxxxxx");
    assertNotNull(session);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/checkout/sessions/cs_test_xxxxxxxxxxxxx");
  }

  @Test
  public void testSessionList() throws JaguarException {
    com.jaguar.param.checkout.SessionListParams params =
        com.jaguar.param.checkout.SessionListParams.builder().setLimit(3L).build();

    com.jaguar.model.checkout.SessionCollection sessions =
        com.jaguar.model.checkout.Session.list(params);
    assertNotNull(sessions);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/checkout/sessions", params.toMap());
  }

  @Test
  public void testCouponCreate() throws JaguarException {
    CouponCreateParams params =
        CouponCreateParams.builder()
            .setPercentOff(new BigDecimal(25))
            .setDuration(CouponCreateParams.Duration.REPEATING)
            .setDurationInMonths(3L)
            .build();

    Coupon coupon = Coupon.create(params);
    assertNotNull(coupon);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/coupons", params.toMap());
  }

  @Test
  public void testCouponRetrieve() throws JaguarException {
    Coupon coupon = Coupon.retrieve("25_5OFF");
    assertNotNull(coupon);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/coupons/25_5OFF");
  }

  @Test
  public void testCouponUpdate() throws JaguarException {
    Coupon resource = Coupon.retrieve("co_xxxxxxxxxxxxx");
    CouponUpdateParams params =
        CouponUpdateParams.builder().putMetadata("order_id", "6735").build();

    Coupon coupon = resource.update(params);
    assertNotNull(coupon);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/coupons/co_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testCouponDelete() throws JaguarException {
    Coupon resource = Coupon.retrieve("co_xxxxxxxxxxxxx");

    Coupon coupon = resource.delete();
    assertNotNull(coupon);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/coupons/co_xxxxxxxxxxxxx");
  }

  @Test
  public void testCouponList() throws JaguarException {
    CouponListParams params = CouponListParams.builder().setLimit(3L).build();

    CouponCollection coupons = Coupon.list(params);
    assertNotNull(coupons);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/coupons", params.toMap());
  }

  @Test
  public void testCreditNotePreview() throws JaguarException {
    CreditNotePreviewParams params =
        CreditNotePreviewParams.builder()
            .setInvoice("in_xxxxxxxxxxxxx")
            .addLine(
                CreditNotePreviewParams.Line.builder()
                    .setType(CreditNotePreviewParams.Line.Type.INVOICE_LINE_ITEM)
                    .setInvoiceLineItem("il_xxxxxxxxxxxxx")
                    .setQuantity(1L)
                    .build())
            .build();

    CreditNote creditNote = CreditNote.preview(params);
    assertNotNull(creditNote);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/credit_notes/preview", params.toMap());
  }

  @Test
  public void testCreditNoteCreate() throws JaguarException {
    CreditNoteCreateParams params =
        CreditNoteCreateParams.builder()
            .setInvoice("in_xxxxxxxxxxxxx")
            .addLine(
                CreditNoteCreateParams.Line.builder()
                    .setType(CreditNoteCreateParams.Line.Type.INVOICE_LINE_ITEM)
                    .setInvoiceLineItem("il_xxxxxxxxxxxxx")
                    .setQuantity(1L)
                    .build())
            .build();

    CreditNote creditNote = CreditNote.create(params);
    assertNotNull(creditNote);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/credit_notes", params.toMap());
  }

  @Test
  public void testCreditNoteRetrieve() throws JaguarException {
    CreditNote creditNote = CreditNote.retrieve("cn_xxxxxxxxxxxxx");
    assertNotNull(creditNote);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/credit_notes/cn_xxxxxxxxxxxxx");
  }

  @Test
  public void testCreditNoteUpdate() throws JaguarException {
    CreditNote resource = CreditNote.retrieve("cn_xxxxxxxxxxxxx");
    CreditNoteUpdateParams params =
        CreditNoteUpdateParams.builder().putMetadata("order_id", "6735").build();

    CreditNote creditNote = resource.update(params);
    assertNotNull(creditNote);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/credit_notes/cn_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testCreditNoteLineItemList() throws JaguarException {
    CreditNote creditNote = CreditNote.retrieve("cn_xxxxxxxxxxxxx");
    CreditNoteLineItemCollectionListParams params =
        CreditNoteLineItemCollectionListParams.builder().setLimit(3L).build();

    CreditNoteLineItemCollection creditNoteLineItems = creditNote.getLines().list(params);
    assertNotNull(creditNoteLineItems);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/credit_notes/cn_xxxxxxxxxxxxx/lines", params.toMap());
  }

  @Test
  public void testCreditNotePreview2() throws JaguarException {
    CreditNotePreviewParams params =
        CreditNotePreviewParams.builder()
            .setInvoice("in_xxxxxxxxxxxxx")
            .addLine(
                CreditNotePreviewParams.Line.builder()
                    .setType(CreditNotePreviewParams.Line.Type.INVOICE_LINE_ITEM)
                    .setInvoiceLineItem("il_xxxxxxxxxxxxx")
                    .setQuantity(1L)
                    .build())
            .build();

    CreditNote creditNote = CreditNote.preview(params);
    assertNotNull(creditNote);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/credit_notes/preview", params.toMap());
  }

  @Test
  public void testCreditNoteVoidCreditNote() throws JaguarException {
    CreditNote resource = CreditNote.retrieve("cn_xxxxxxxxxxxxx");
    CreditNoteVoidCreditNoteParams params = CreditNoteVoidCreditNoteParams.builder().build();

    CreditNote creditNote = resource.voidCreditNote(params);
    assertNotNull(creditNote);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/credit_notes/cn_xxxxxxxxxxxxx/void", params.toMap());
  }

  @Test
  public void testCreditNoteList() throws JaguarException {
    CreditNoteListParams params = CreditNoteListParams.builder().setLimit(3L).build();

    CreditNoteCollection creditNotes = CreditNote.list(params);
    assertNotNull(creditNotes);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/credit_notes", params.toMap());
  }

  @Test
  public void testCustomerBalanceTransactionCreate() throws JaguarException {
    Customer customer = Customer.retrieve("cus_xxxxxxxxxxxxx");
    CustomerBalanceTransactionCollectionCreateParams params =
        CustomerBalanceTransactionCollectionCreateParams.builder()
            .setAmount(-500L)
            .setCurrency("usd")
            .build();

    CustomerBalanceTransaction customerBalanceTransaction =
        customer.balanceTransactions().create(params);
    assertNotNull(customerBalanceTransaction);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/customers/cus_xxxxxxxxxxxxx/balance_transactions",
        params.toMap());
  }

  @Test
  public void testCustomerBalanceTransactionRetrieve() throws JaguarException {
    Customer customer = Customer.retrieve("cus_xxxxxxxxxxxxx");

    CustomerBalanceTransaction customerBalanceTransaction =
        customer.balanceTransactions().retrieve("cbtxn_xxxxxxxxxxxxx");
    assertNotNull(customerBalanceTransaction);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        "/v1/customers/cus_xxxxxxxxxxxxx/balance_transactions/cbtxn_xxxxxxxxxxxxx");
  }

  @Test
  public void testCustomerBalanceTransactionUpdate() throws JaguarException {
    Customer customer = Customer.retrieve("cus_xxxxxxxxxxxxx");
    CustomerBalanceTransaction resource =
        customer.balanceTransactions().retrieve("cbtxn_xxxxxxxxxxxxx");
    CustomerBalanceTransactionUpdateParams params =
        CustomerBalanceTransactionUpdateParams.builder().putMetadata("order_id", "6735").build();

    CustomerBalanceTransaction customerBalanceTransaction = resource.update(params);
    assertNotNull(customerBalanceTransaction);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/customers/cus_xxxxxxxxxxxxx/balance_transactions/cbtxn_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testSessionCreate2() throws JaguarException {
    com.jaguar.param.billingportal.SessionCreateParams params =
        com.jaguar.param.billingportal.SessionCreateParams.builder()
            .setCustomer("cus_xxxxxxxxxxxxx")
            .setReturnUrl("https://example.com/account")
            .build();

    com.jaguar.model.billingportal.Session session =
        com.jaguar.model.billingportal.Session.create(params);
    assertNotNull(session);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/billing_portal/sessions", params.toMap());
  }

  @Test
  public void testConfigurationCreate() throws JaguarException {
    com.jaguar.param.billingportal.ConfigurationCreateParams params =
        com.jaguar.param.billingportal.ConfigurationCreateParams.builder()
            .setFeatures(
                com.jaguar.param.billingportal.ConfigurationCreateParams.Features.builder()
                    .setCustomerUpdate(
                        com.jaguar.param.billingportal.ConfigurationCreateParams.Features
                            .CustomerUpdate.builder()
                            .addAllowedUpdate(
                                com.jaguar.param.billingportal.ConfigurationCreateParams.Features
                                    .CustomerUpdate.AllowedUpdate.EMAIL)
                            .addAllowedUpdate(
                                com.jaguar.param.billingportal.ConfigurationCreateParams.Features
                                    .CustomerUpdate.AllowedUpdate.TAX_ID)
                            .setEnabled(true)
                            .build())
                    .setInvoiceHistory(
                        com.jaguar.param.billingportal.ConfigurationCreateParams.Features
                            .InvoiceHistory.builder()
                            .setEnabled(true)
                            .build())
                    .build())
            .setBusinessProfile(
                com.jaguar.param.billingportal.ConfigurationCreateParams.BusinessProfile.builder()
                    .setPrivacyPolicyUrl("https://example.com/privacy")
                    .setTermsOfServiceUrl("https://example.com/terms")
                    .build())
            .build();

    com.jaguar.model.billingportal.Configuration configuration =
        com.jaguar.model.billingportal.Configuration.create(params);
    assertNotNull(configuration);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/billing_portal/configurations", params.toMap());
  }

  @Test
  public void testConfigurationUpdate() throws JaguarException {
    com.jaguar.model.billingportal.Configuration resource =
        com.jaguar.model.billingportal.Configuration.retrieve("bpc_xxxxxxxxxxxxx");
    com.jaguar.param.billingportal.ConfigurationUpdateParams params =
        com.jaguar.param.billingportal.ConfigurationUpdateParams.builder()
            .setBusinessProfile(
                com.jaguar.param.billingportal.ConfigurationUpdateParams.BusinessProfile.builder()
                    .setPrivacyPolicyUrl("https://example.com/privacy")
                    .setTermsOfServiceUrl("https://example.com/terms")
                    .build())
            .build();

    com.jaguar.model.billingportal.Configuration configuration = resource.update(params);
    assertNotNull(configuration);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/billing_portal/configurations/bpc_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testConfigurationRetrieve() throws JaguarException {
    com.jaguar.model.billingportal.Configuration configuration =
        com.jaguar.model.billingportal.Configuration.retrieve("bpc_xxxxxxxxxxxxx");
    assertNotNull(configuration);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/billing_portal/configurations/bpc_xxxxxxxxxxxxx");
  }

  @Test
  public void testConfigurationList() throws JaguarException {
    com.jaguar.param.billingportal.ConfigurationListParams params =
        com.jaguar.param.billingportal.ConfigurationListParams.builder().setLimit(3L).build();

    com.jaguar.model.billingportal.ConfigurationCollection configurations =
        com.jaguar.model.billingportal.Configuration.list(params);
    assertNotNull(configurations);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/billing_portal/configurations", params.toMap());
  }

  @Test
  public void testInvoiceCreate() throws JaguarException {
    InvoiceCreateParams params =
        InvoiceCreateParams.builder().setCustomer("cus_xxxxxxxxxxxxx").build();

    Invoice invoice = Invoice.create(params);
    assertNotNull(invoice);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/invoices", params.toMap());
  }

  @Test
  public void testInvoiceRetrieve() throws JaguarException {
    Invoice invoice = Invoice.retrieve("in_xxxxxxxxxxxxx");
    assertNotNull(invoice);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/invoices/in_xxxxxxxxxxxxx");
  }

  @Test
  public void testInvoiceUpdate() throws JaguarException {
    Invoice resource = Invoice.retrieve("in_xxxxxxxxxxxxx");
    InvoiceUpdateParams params =
        InvoiceUpdateParams.builder().putMetadata("order_id", "6735").build();

    Invoice invoice = resource.update(params);
    assertNotNull(invoice);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/invoices/in_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testInvoiceDelete() throws JaguarException {
    Invoice resource = Invoice.retrieve("in_xxxxxxxxxxxxx");

    Invoice invoice = resource.delete();
    assertNotNull(invoice);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/invoices/in_xxxxxxxxxxxxx");
  }

  @Test
  public void testInvoiceFinalizeInvoice() throws JaguarException {
    Invoice resource = Invoice.retrieve("in_xxxxxxxxxxxxx");
    InvoiceFinalizeInvoiceParams params = InvoiceFinalizeInvoiceParams.builder().build();

    Invoice invoice = resource.finalizeInvoice(params);
    assertNotNull(invoice);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/invoices/in_xxxxxxxxxxxxx/finalize", params.toMap());
  }

  @Test
  public void testInvoicePay() throws JaguarException {
    Invoice resource = Invoice.retrieve("in_xxxxxxxxxxxxx");
    InvoicePayParams params = InvoicePayParams.builder().build();

    Invoice invoice = resource.pay(params);
    assertNotNull(invoice);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/invoices/in_xxxxxxxxxxxxx/pay", params.toMap());
  }

  @Test
  public void testInvoiceSendInvoice() throws JaguarException {
    Invoice resource = Invoice.retrieve("in_xxxxxxxxxxxxx");
    InvoiceSendInvoiceParams params = InvoiceSendInvoiceParams.builder().build();

    Invoice invoice = resource.sendInvoice(params);
    assertNotNull(invoice);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/invoices/in_xxxxxxxxxxxxx/send", params.toMap());
  }

  @Test
  public void testInvoiceVoidInvoice() throws JaguarException {
    Invoice resource = Invoice.retrieve("in_xxxxxxxxxxxxx");
    InvoiceVoidInvoiceParams params = InvoiceVoidInvoiceParams.builder().build();

    Invoice invoice = resource.voidInvoice(params);
    assertNotNull(invoice);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/invoices/in_xxxxxxxxxxxxx/void", params.toMap());
  }

  @Test
  public void testInvoiceMarkUncollectible() throws JaguarException {
    Invoice resource = Invoice.retrieve("in_xxxxxxxxxxxxx");
    InvoiceMarkUncollectibleParams params = InvoiceMarkUncollectibleParams.builder().build();

    Invoice invoice = resource.markUncollectible(params);
    assertNotNull(invoice);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/invoices/in_xxxxxxxxxxxxx/mark_uncollectible",
        params.toMap());
  }

  @Test
  public void testInvoiceList() throws JaguarException {
    InvoiceListParams params = InvoiceListParams.builder().setLimit(3L).build();

    InvoiceCollection invoices = Invoice.list(params);
    assertNotNull(invoices);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/invoices", params.toMap());
  }

  @Test
  public void testInvoiceItemCreate() throws JaguarException {
    InvoiceItemCreateParams params =
        InvoiceItemCreateParams.builder()
            .setCustomer("cus_xxxxxxxxxxxxx")
            .setPrice("price_xxxxxxxxxxxxx")
            .build();

    InvoiceItem invoiceItem = InvoiceItem.create(params);
    assertNotNull(invoiceItem);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/invoiceitems", params.toMap());
  }

  @Test
  public void testInvoiceItemRetrieve() throws JaguarException {
    InvoiceItem invoiceItem = InvoiceItem.retrieve("ii_xxxxxxxxxxxxx");
    assertNotNull(invoiceItem);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/invoiceitems/ii_xxxxxxxxxxxxx");
  }

  @Test
  public void testInvoiceItemUpdate() throws JaguarException {
    InvoiceItem resource = InvoiceItem.retrieve("ii_xxxxxxxxxxxxx");
    InvoiceItemUpdateParams params =
        InvoiceItemUpdateParams.builder().putMetadata("order_id", "6735").build();

    InvoiceItem invoiceItem = resource.update(params);
    assertNotNull(invoiceItem);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/invoiceitems/ii_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testInvoiceItemDelete() throws JaguarException {
    InvoiceItem resource = InvoiceItem.retrieve("ii_xxxxxxxxxxxxx");

    InvoiceItem invoiceItem = resource.delete();
    assertNotNull(invoiceItem);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/invoiceitems/ii_xxxxxxxxxxxxx");
  }

  @Test
  public void testInvoiceItemList() throws JaguarException {
    InvoiceItemListParams params = InvoiceItemListParams.builder().setLimit(3L).build();

    InvoiceItemCollection invoiceItems = InvoiceItem.list(params);
    assertNotNull(invoiceItems);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/invoiceitems", params.toMap());
  }

  @Test
  public void testPlanCreate() throws JaguarException {
    PlanCreateParams params =
        PlanCreateParams.builder()
            .setAmount(2000L)
            .setCurrency("usd")
            .setInterval(PlanCreateParams.Interval.MONTH)
            .setProduct("prod_xxxxxxxxxxxxx")
            .build();

    Plan plan = Plan.create(params);
    assertNotNull(plan);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/plans", params.toMap());
  }

  @Test
  public void testPlanRetrieve() throws JaguarException {
    Plan plan = Plan.retrieve("price_xxxxxxxxxxxxx");
    assertNotNull(plan);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/plans/price_xxxxxxxxxxxxx");
  }

  @Test
  public void testPlanUpdate() throws JaguarException {
    Plan resource = Plan.retrieve("price_xxxxxxxxxxxxx");
    PlanUpdateParams params = PlanUpdateParams.builder().putMetadata("order_id", "6735").build();

    Plan plan = resource.update(params);
    assertNotNull(plan);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/plans/price_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testPlanDelete() throws JaguarException {
    Plan resource = Plan.retrieve("price_xxxxxxxxxxxxx");

    Plan plan = resource.delete();
    assertNotNull(plan);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/plans/price_xxxxxxxxxxxxx");
  }

  @Test
  public void testPlanList() throws JaguarException {
    PlanListParams params = PlanListParams.builder().setLimit(3L).build();

    PlanCollection plans = Plan.list(params);
    assertNotNull(plans);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/plans", params.toMap());
  }

  @Test
  public void testPromotionCodeCreate() throws JaguarException {
    PromotionCodeCreateParams params =
        PromotionCodeCreateParams.builder().setCoupon("25_5OFF").build();

    PromotionCode promotionCode = PromotionCode.create(params);
    assertNotNull(promotionCode);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/promotion_codes", params.toMap());
  }

  @Test
  public void testPromotionCodeUpdate() throws JaguarException {
    PromotionCode resource = PromotionCode.retrieve("promo_xxxxxxxxxxxxx");
    PromotionCodeUpdateParams params =
        PromotionCodeUpdateParams.builder().putMetadata("order_id", "6735").build();

    PromotionCode promotionCode = resource.update(params);
    assertNotNull(promotionCode);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/promotion_codes/promo_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testPromotionCodeRetrieve() throws JaguarException {
    PromotionCode promotionCode = PromotionCode.retrieve("promo_xxxxxxxxxxxxx");
    assertNotNull(promotionCode);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/promotion_codes/promo_xxxxxxxxxxxxx");
  }

  @Test
  public void testPromotionCodeList() throws JaguarException {
    PromotionCodeListParams params = PromotionCodeListParams.builder().setLimit(3L).build();

    PromotionCodeCollection promotionCodes = PromotionCode.list(params);
    assertNotNull(promotionCodes);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/promotion_codes", params.toMap());
  }

  @Test
  public void testSubscriptionCreate() throws JaguarException {
    SubscriptionCreateParams params =
        SubscriptionCreateParams.builder()
            .setCustomer("cus_xxxxxxxxxxxxx")
            .addItem(
                SubscriptionCreateParams.Item.builder().setPrice("price_xxxxxxxxxxxxx").build())
            .build();

    Subscription subscription = Subscription.create(params);
    assertNotNull(subscription);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/subscriptions", params.toMap());
  }

  @Test
  public void testSubscriptionRetrieve() throws JaguarException {
    Subscription subscription = Subscription.retrieve("sub_xxxxxxxxxxxxx");
    assertNotNull(subscription);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/subscriptions/sub_xxxxxxxxxxxxx");
  }

  @Test
  public void testSubscriptionUpdate() throws JaguarException {
    Subscription resource = Subscription.retrieve("sub_xxxxxxxxxxxxx");
    SubscriptionUpdateParams params =
        SubscriptionUpdateParams.builder().putMetadata("order_id", "6735").build();

    Subscription subscription = resource.update(params);
    assertNotNull(subscription);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/subscriptions/sub_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testSubscriptionCancel() throws JaguarException {
    Subscription resource = Subscription.retrieve("sub_xxxxxxxxxxxxx");
    SubscriptionCancelParams params = SubscriptionCancelParams.builder().build();

    Subscription subscription = resource.cancel(params);
    assertNotNull(subscription);
    verifyRequest(
        ApiResource.RequestMethod.DELETE, "/v1/subscriptions/sub_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testSubscriptionList() throws JaguarException {
    SubscriptionListParams params = SubscriptionListParams.builder().setLimit(3L).build();

    SubscriptionCollection subscriptions = Subscription.list(params);
    assertNotNull(subscriptions);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/subscriptions", params.toMap());
  }

  @Test
  public void testSubscriptionItemCreate() throws JaguarException {
    SubscriptionItemCreateParams params =
        SubscriptionItemCreateParams.builder()
            .setSubscription("sub_xxxxxxxxxxxxx")
            .setPrice("price_xxxxxxxxxxxxx")
            .setQuantity(2L)
            .build();

    SubscriptionItem subscriptionItem = SubscriptionItem.create(params);
    assertNotNull(subscriptionItem);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/subscription_items", params.toMap());
  }

  @Test
  public void testSubscriptionItemRetrieve() throws JaguarException {
    SubscriptionItem subscriptionItem = SubscriptionItem.retrieve("si_xxxxxxxxxxxxx");
    assertNotNull(subscriptionItem);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/subscription_items/si_xxxxxxxxxxxxx");
  }

  @Test
  public void testSubscriptionItemUpdate() throws JaguarException {
    SubscriptionItem resource = SubscriptionItem.retrieve("si_xxxxxxxxxxxxx");
    SubscriptionItemUpdateParams params =
        SubscriptionItemUpdateParams.builder().putMetadata("order_id", "6735").build();

    SubscriptionItem subscriptionItem = resource.update(params);
    assertNotNull(subscriptionItem);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/subscription_items/si_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testSubscriptionItemDelete() throws JaguarException {
    SubscriptionItem resource = SubscriptionItem.retrieve("si_xxxxxxxxxxxxx");
    SubscriptionItemDeleteParams params = SubscriptionItemDeleteParams.builder().build();

    SubscriptionItem subscriptionItem = resource.delete(params);
    assertNotNull(subscriptionItem);
    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        "/v1/subscription_items/si_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testSubscriptionItemList() throws JaguarException {
    SubscriptionItemListParams params =
        SubscriptionItemListParams.builder().setSubscription("sub_xxxxxxxxxxxxx").build();

    SubscriptionItemCollection subscriptionItems = SubscriptionItem.list(params);
    assertNotNull(subscriptionItems);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/subscription_items", params.toMap());
  }

  @Test
  public void testSubscriptionScheduleCreate() throws JaguarException {
    SubscriptionScheduleCreateParams params =
        SubscriptionScheduleCreateParams.builder()
            .setCustomer("cus_xxxxxxxxxxxxx")
            .setStartDate(1620753115L)
            .setEndBehavior(SubscriptionScheduleCreateParams.EndBehavior.RELEASE)
            .addPhase(
                SubscriptionScheduleCreateParams.Phase.builder()
                    .addItem(
                        SubscriptionScheduleCreateParams.Phase.Item.builder()
                            .setPrice("price_xxxxxxxxxxxxx")
                            .setQuantity(1L)
                            .build())
                    .setIterations(12L)
                    .build())
            .build();

    SubscriptionSchedule subscriptionSchedule = SubscriptionSchedule.create(params);
    assertNotNull(subscriptionSchedule);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/subscription_schedules", params.toMap());
  }

  @Test
  public void testSubscriptionScheduleRetrieve() throws JaguarException {
    SubscriptionSchedule subscriptionSchedule =
        SubscriptionSchedule.retrieve("sub_sched_xxxxxxxxxxxxx");
    assertNotNull(subscriptionSchedule);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/subscription_schedules/sub_sched_xxxxxxxxxxxxx");
  }

  @Test
  public void testSubscriptionScheduleUpdate() throws JaguarException {
    SubscriptionSchedule resource = SubscriptionSchedule.retrieve("sub_sched_xxxxxxxxxxxxx");
    SubscriptionScheduleUpdateParams params =
        SubscriptionScheduleUpdateParams.builder()
            .setEndBehavior(SubscriptionScheduleUpdateParams.EndBehavior.RELEASE)
            .build();

    SubscriptionSchedule subscriptionSchedule = resource.update(params);
    assertNotNull(subscriptionSchedule);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/subscription_schedules/sub_sched_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testSubscriptionScheduleCancel() throws JaguarException {
    SubscriptionSchedule resource = SubscriptionSchedule.retrieve("sub_sched_xxxxxxxxxxxxx");
    SubscriptionScheduleCancelParams params = SubscriptionScheduleCancelParams.builder().build();

    SubscriptionSchedule subscriptionSchedule = resource.cancel(params);
    assertNotNull(subscriptionSchedule);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/subscription_schedules/sub_sched_xxxxxxxxxxxxx/cancel",
        params.toMap());
  }

  @Test
  public void testSubscriptionScheduleRelease() throws JaguarException {
    SubscriptionSchedule resource = SubscriptionSchedule.retrieve("sub_sched_xxxxxxxxxxxxx");
    SubscriptionScheduleReleaseParams params = SubscriptionScheduleReleaseParams.builder().build();

    SubscriptionSchedule subscriptionSchedule = resource.release(params);
    assertNotNull(subscriptionSchedule);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/subscription_schedules/sub_sched_xxxxxxxxxxxxx/release",
        params.toMap());
  }

  @Test
  public void testSubscriptionScheduleList() throws JaguarException {
    SubscriptionScheduleListParams params =
        SubscriptionScheduleListParams.builder().setLimit(3L).build();

    SubscriptionScheduleCollection subscriptionSchedules = SubscriptionSchedule.list(params);
    assertNotNull(subscriptionSchedules);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/subscription_schedules", params.toMap());
  }

  @Test
  public void testTaxRateCreate() throws JaguarException {
    TaxRateCreateParams params =
        TaxRateCreateParams.builder()
            .setDisplayName("VAT")
            .setDescription("VAT Germany")
            .setJurisdiction("DE")
            .setPercentage(new BigDecimal(16))
            .setInclusive(false)
            .build();

    TaxRate taxRate = TaxRate.create(params);
    assertNotNull(taxRate);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/tax_rates", params.toMap());
  }

  @Test
  public void testTaxRateRetrieve() throws JaguarException {
    TaxRate taxRate = TaxRate.retrieve("txr_xxxxxxxxxxxxx");
    assertNotNull(taxRate);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/tax_rates/txr_xxxxxxxxxxxxx");
  }

  @Test
  public void testTaxRateUpdate() throws JaguarException {
    TaxRate resource = TaxRate.retrieve("txr_xxxxxxxxxxxxx");
    TaxRateUpdateParams params = TaxRateUpdateParams.builder().setActive(false).build();

    TaxRate taxRate = resource.update(params);
    assertNotNull(taxRate);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/tax_rates/txr_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testTaxRateList() throws JaguarException {
    TaxRateListParams params = TaxRateListParams.builder().setLimit(3L).build();

    TaxRateCollection taxRates = TaxRate.list(params);
    assertNotNull(taxRates);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/tax_rates", params.toMap());
  }

  @Test
  public void testAccountCreate() throws JaguarException {
    AccountCreateParams params =
        AccountCreateParams.builder()
            .setType(AccountCreateParams.Type.CUSTOM)
            .setCountry("US")
            .setEmail("jenny.rosen@example.com")
            .setCapabilities(
                AccountCreateParams.Capabilities.builder()
                    .setCardPayments(
                        AccountCreateParams.Capabilities.CardPayments.builder()
                            .setRequested(true)
                            .build())
                    .setTransfers(
                        AccountCreateParams.Capabilities.Transfers.builder()
                            .setRequested(true)
                            .build())
                    .build())
            .build();

    Account account = Account.create(params);
    assertNotNull(account);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/accounts", params.toMap());
  }

  @Test
  public void testAccountRetrieve() throws JaguarException {
    Account account = Account.retrieve("acct_xxxxxxxxxxxxx");
    assertNotNull(account);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/accounts/acct_xxxxxxxxxxxxx");
  }

  @Test
  public void testAccountUpdate() throws JaguarException {
    Account resource = Account.retrieve("acct_xxxxxxxxxxxxx");
    AccountUpdateParams params =
        AccountUpdateParams.builder().putMetadata("order_id", "6735").build();

    Account account = resource.update(params);
    assertNotNull(account);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/accounts/acct_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testAccountDelete() throws JaguarException {
    Account resource = Account.retrieve("acct_xxxxxxxxxxxxx");

    Account account = resource.delete();
    assertNotNull(account);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/accounts/acct_xxxxxxxxxxxxx");
  }

  @Test
  public void testAccountReject() throws JaguarException {
    Account resource = Account.retrieve("acct_xxxxxxxxxxxxx");
    AccountRejectParams params = AccountRejectParams.builder().setReason("fraud").build();

    Account account = resource.reject(params);
    assertNotNull(account);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/accounts/acct_xxxxxxxxxxxxx/reject", params.toMap());
  }

  @Test
  public void testAccountList() throws JaguarException {
    AccountListParams params = AccountListParams.builder().setLimit(3L).build();

    AccountCollection accounts = Account.list(params);
    assertNotNull(accounts);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/accounts", params.toMap());
  }

  @Test
  public void testAccountLinkCreate() throws JaguarException {
    AccountLinkCreateParams params =
        AccountLinkCreateParams.builder()
            .setAccount("acct_xxxxxxxxxxxxx")
            .setRefreshUrl("https://example.com/reauth")
            .setReturnUrl("https://example.com/return")
            .setType(AccountLinkCreateParams.Type.ACCOUNT_ONBOARDING)
            .build();

    AccountLink accountLink = AccountLink.create(params);
    assertNotNull(accountLink);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/account_links", params.toMap());
  }

  @Test
  public void testApplicationFeeRetrieve() throws JaguarException {
    ApplicationFee applicationFee = ApplicationFee.retrieve("fee_xxxxxxxxxxxxx");
    assertNotNull(applicationFee);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/application_fees/fee_xxxxxxxxxxxxx");
  }

  @Test
  public void testApplicationFeeList() throws JaguarException {
    ApplicationFeeListParams params = ApplicationFeeListParams.builder().setLimit(3L).build();

    ApplicationFeeCollection applicationFees = ApplicationFee.list(params);
    assertNotNull(applicationFees);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/application_fees", params.toMap());
  }

  @Test
  public void testFeeRefundCreate() throws JaguarException {
    ApplicationFee applicationFee = ApplicationFee.retrieve("fee_xxxxxxxxxxxxx");
    FeeRefundCollectionCreateParams params = FeeRefundCollectionCreateParams.builder().build();

    FeeRefund feeRefund = applicationFee.getRefunds().create(params);
    assertNotNull(feeRefund);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/application_fees/fee_xxxxxxxxxxxxx/refunds",
        params.toMap());
  }

  @Test
  public void testFeeRefundRetrieve() throws JaguarException {
    ApplicationFee applicationFee = ApplicationFee.retrieve("fee_xxxxxxxxxxxxx");

    FeeRefund feeRefund = applicationFee.getRefunds().retrieve("fr_xxxxxxxxxxxxx");
    assertNotNull(feeRefund);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        "/v1/application_fees/fee_xxxxxxxxxxxxx/refunds/fr_xxxxxxxxxxxxx");
  }

  @Test
  public void testFeeRefundUpdate() throws JaguarException {
    ApplicationFee applicationFee = ApplicationFee.retrieve("fee_xxxxxxxxxxxxx");
    FeeRefund resource = applicationFee.getRefunds().retrieve("fr_xxxxxxxxxxxxx");
    FeeRefundUpdateParams params =
        FeeRefundUpdateParams.builder().putMetadata("order_id", "6735").build();

    FeeRefund feeRefund = resource.update(params);
    assertNotNull(feeRefund);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/application_fees/fee_xxxxxxxxxxxxx/refunds/fr_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testFeeRefundList() throws JaguarException {
    ApplicationFee applicationFee = ApplicationFee.retrieve("fee_xxxxxxxxxxxxx");
    FeeRefundCollectionListParams params =
        FeeRefundCollectionListParams.builder().setLimit(3L).build();

    FeeRefundCollection feeRefunds = applicationFee.getRefunds().list(params);
    assertNotNull(feeRefunds);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        "/v1/application_fees/fee_xxxxxxxxxxxxx/refunds",
        params.toMap());
  }

  @Test
  public void testCapabilityRetrieve() throws JaguarException {
    Account account = Account.retrieve("acct_xxxxxxxxxxxxx");

    Capability capability = account.capabilities().retrieve("card_payments");
    assertNotNull(capability);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        "/v1/accounts/acct_xxxxxxxxxxxxx/capabilities/card_payments");
  }

  @Test
  public void testCapabilityUpdate() throws JaguarException {
    Account account = Account.retrieve("acct_xxxxxxxxxxxxx");
    Capability resource = account.capabilities().retrieve("card_payments");
    CapabilityUpdateParams params = CapabilityUpdateParams.builder().setRequested(true).build();

    Capability capability = resource.update(params);
    assertNotNull(capability);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/accounts/acct_xxxxxxxxxxxxx/capabilities/card_payments",
        params.toMap());
  }

  @Test
  public void testCountrySpecList() throws JaguarException {
    CountrySpecListParams params = CountrySpecListParams.builder().setLimit(3L).build();

    CountrySpecCollection countrySpecs = CountrySpec.list(params);
    assertNotNull(countrySpecs);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/country_specs", params.toMap());
  }

  @Test
  public void testCountrySpecRetrieve() throws JaguarException {
    CountrySpec countrySpec = CountrySpec.retrieve("US");
    assertNotNull(countrySpec);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/country_specs/US");
  }

  @Test
  public void testPersonCreate() throws JaguarException {
    Account account = Account.retrieve("acct_xxxxxxxxxxxxx");
    PersonCollectionCreateParams params =
        PersonCollectionCreateParams.builder().setFirstName("Jane").setLastName("Diaz").build();

    Person person = account.persons().create(params);
    assertNotNull(person);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/accounts/acct_xxxxxxxxxxxxx/persons", params.toMap());
  }

  @Test
  public void testPersonRetrieve() throws JaguarException {
    Account account = Account.retrieve("acct_xxxxxxxxxxxxx");

    Person person = account.persons().retrieve("person_xxxxxxxxxxxxx");
    assertNotNull(person);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        "/v1/accounts/acct_xxxxxxxxxxxxx/persons/person_xxxxxxxxxxxxx");
  }

  @Test
  public void testPersonUpdate() throws JaguarException {
    Account account = Account.retrieve("acct_xxxxxxxxxxxxx");
    Person resource = account.persons().retrieve("person_xxxxxxxxxxxxx");
    PersonUpdateParams params =
        PersonUpdateParams.builder().putMetadata("order_id", "6735").build();

    Person person = resource.update(params);
    assertNotNull(person);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/accounts/acct_xxxxxxxxxxxxx/persons/person_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testPersonDelete() throws JaguarException {
    Account account = Account.retrieve("acct_xxxxxxxxxxxxx");
    Person resource = account.persons().retrieve("person_xxxxxxxxxxxxx");

    Person person = resource.delete();
    assertNotNull(person);
    verifyRequest(
        ApiResource.RequestMethod.DELETE,
        "/v1/accounts/acct_xxxxxxxxxxxxx/persons/person_xxxxxxxxxxxxx");
  }

  @Test
  public void testPersonList() throws JaguarException {
    Account account = Account.retrieve("acct_xxxxxxxxxxxxx");
    PersonCollectionListParams params = PersonCollectionListParams.builder().setLimit(3L).build();

    PersonCollection persons = account.persons().list(params);
    assertNotNull(persons);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/accounts/acct_xxxxxxxxxxxxx/persons", params.toMap());
  }

  @Test
  public void testTopupCreate() throws JaguarException {
    TopupCreateParams params =
        TopupCreateParams.builder()
            .setAmount(2000L)
            .setCurrency("usd")
            .setDescription("Top-up for Jenny Rosen")
            .setStatementDescriptor("Top-up")
            .build();

    Topup topup = Topup.create(params);
    assertNotNull(topup);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/topups", params.toMap());
  }

  @Test
  public void testTopupRetrieve() throws JaguarException {
    Topup topup = Topup.retrieve("tu_xxxxxxxxxxxxx");
    assertNotNull(topup);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/topups/tu_xxxxxxxxxxxxx");
  }

  @Test
  public void testTopupUpdate() throws JaguarException {
    Topup resource = Topup.retrieve("tu_xxxxxxxxxxxxx");
    TopupUpdateParams params = TopupUpdateParams.builder().putMetadata("order_id", "6735").build();

    Topup topup = resource.update(params);
    assertNotNull(topup);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/topups/tu_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testTopupList() throws JaguarException {
    TopupListParams params = TopupListParams.builder().setLimit(3L).build();

    TopupCollection topups = Topup.list(params);
    assertNotNull(topups);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/topups", params.toMap());
  }

  @Test
  public void testTopupCancel() throws JaguarException {
    Topup resource = Topup.retrieve("tu_xxxxxxxxxxxxx");
    TopupCancelParams params = TopupCancelParams.builder().build();

    Topup topup = resource.cancel(params);
    assertNotNull(topup);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/topups/tu_xxxxxxxxxxxxx/cancel", params.toMap());
  }

  @Test
  public void testTransferCreate() throws JaguarException {
    TransferCreateParams params =
        TransferCreateParams.builder()
            .setAmount(400L)
            .setCurrency("usd")
            .setDestination("acct_xxxxxxxxxxxxx")
            .setTransferGroup("ORDER_95")
            .build();

    Transfer transfer = Transfer.create(params);
    assertNotNull(transfer);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/transfers", params.toMap());
  }

  @Test
  public void testTransferRetrieve() throws JaguarException {
    Transfer transfer = Transfer.retrieve("tr_xxxxxxxxxxxxx");
    assertNotNull(transfer);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/transfers/tr_xxxxxxxxxxxxx");
  }

  @Test
  public void testTransferUpdate() throws JaguarException {
    Transfer resource = Transfer.retrieve("tr_xxxxxxxxxxxxx");
    TransferUpdateParams params =
        TransferUpdateParams.builder().putMetadata("order_id", "6735").build();

    Transfer transfer = resource.update(params);
    assertNotNull(transfer);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/transfers/tr_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testTransferList() throws JaguarException {
    TransferListParams params = TransferListParams.builder().setLimit(3L).build();

    TransferCollection transfers = Transfer.list(params);
    assertNotNull(transfers);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/transfers", params.toMap());
  }

  @Test
  public void testTransferReversalCreate() throws JaguarException {
    Transfer transfer = Transfer.retrieve("tr_xxxxxxxxxxxxx");
    TransferReversalCollectionCreateParams params =
        TransferReversalCollectionCreateParams.builder().setAmount(100L).build();

    TransferReversal transferReversal = transfer.getReversals().create(params);
    assertNotNull(transferReversal);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/transfers/tr_xxxxxxxxxxxxx/reversals", params.toMap());
  }

  @Test
  public void testTransferReversalRetrieve() throws JaguarException {
    Transfer transfer = Transfer.retrieve("tr_xxxxxxxxxxxxx");

    TransferReversal transferReversal = transfer.getReversals().retrieve("trr_xxxxxxxxxxxxx");
    assertNotNull(transferReversal);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        "/v1/transfers/tr_xxxxxxxxxxxxx/reversals/trr_xxxxxxxxxxxxx");
  }

  @Test
  public void testTransferReversalUpdate() throws JaguarException {
    Transfer transfer = Transfer.retrieve("tr_xxxxxxxxxxxxx");
    TransferReversal resource = transfer.getReversals().retrieve("trr_xxxxxxxxxxxxx");
    TransferReversalUpdateParams params =
        TransferReversalUpdateParams.builder().putMetadata("order_id", "6735").build();

    TransferReversal transferReversal = resource.update(params);
    assertNotNull(transferReversal);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/transfers/tr_xxxxxxxxxxxxx/reversals/trr_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testTransferReversalList() throws JaguarException {
    Transfer transfer = Transfer.retrieve("tr_xxxxxxxxxxxxx");
    TransferReversalCollectionListParams params =
        TransferReversalCollectionListParams.builder().setLimit(3L).build();

    TransferReversalCollection transferReversals = transfer.getReversals().list(params);
    assertNotNull(transferReversals);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/transfers/tr_xxxxxxxxxxxxx/reversals", params.toMap());
  }

  @Test
  public void testEarlyFraudWarningRetrieve() throws JaguarException {
    com.jaguar.model.radar.EarlyFraudWarning earlyFraudWarning =
        com.jaguar.model.radar.EarlyFraudWarning.retrieve("issfr_xxxxxxxxxxxxx");
    assertNotNull(earlyFraudWarning);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/radar/early_fraud_warnings/issfr_xxxxxxxxxxxxx");
  }

  @Test
  public void testEarlyFraudWarningList() throws JaguarException {
    com.jaguar.param.radar.EarlyFraudWarningListParams params =
        com.jaguar.param.radar.EarlyFraudWarningListParams.builder().setLimit(3L).build();

    com.jaguar.model.radar.EarlyFraudWarningCollection earlyFraudWarnings =
        com.jaguar.model.radar.EarlyFraudWarning.list(params);
    assertNotNull(earlyFraudWarnings);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/radar/early_fraud_warnings", params.toMap());
  }

  @Test
  public void testReviewApprove() throws JaguarException {
    Review resource = Review.retrieve("prv_xxxxxxxxxxxxx");
    ReviewApproveParams params = ReviewApproveParams.builder().build();

    Review review = resource.approve(params);
    assertNotNull(review);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/reviews/prv_xxxxxxxxxxxxx/approve", params.toMap());
  }

  @Test
  public void testReviewRetrieve() throws JaguarException {
    Review review = Review.retrieve("prv_xxxxxxxxxxxxx");
    assertNotNull(review);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/reviews/prv_xxxxxxxxxxxxx");
  }

  @Test
  public void testReviewList() throws JaguarException {
    ReviewListParams params = ReviewListParams.builder().setLimit(3L).build();

    ReviewCollection reviews = Review.list(params);
    assertNotNull(reviews);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/reviews", params.toMap());
  }

  @Test
  public void testValueListCreate() throws JaguarException {
    com.jaguar.param.radar.ValueListCreateParams params =
        com.jaguar.param.radar.ValueListCreateParams.builder()
            .setAlias("custom_ip_xxxxxxxxxxxxx")
            .setName("Custom IP Blocklist")
            .setItemType(com.jaguar.param.radar.ValueListCreateParams.ItemType.IP_ADDRESS)
            .build();

    com.jaguar.model.radar.ValueList valueList = com.jaguar.model.radar.ValueList.create(params);
    assertNotNull(valueList);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/radar/value_lists", params.toMap());
  }

  @Test
  public void testValueListRetrieve() throws JaguarException {
    com.jaguar.model.radar.ValueList valueList =
        com.jaguar.model.radar.ValueList.retrieve("rsl_xxxxxxxxxxxxx");
    assertNotNull(valueList);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/radar/value_lists/rsl_xxxxxxxxxxxxx");
  }

  @Test
  public void testValueListUpdate() throws JaguarException {
    com.jaguar.model.radar.ValueList resource =
        com.jaguar.model.radar.ValueList.retrieve("rsl_xxxxxxxxxxxxx");
    com.jaguar.param.radar.ValueListUpdateParams params =
        com.jaguar.param.radar.ValueListUpdateParams.builder()
            .setName("Updated IP Block List")
            .build();

    com.jaguar.model.radar.ValueList valueList = resource.update(params);
    assertNotNull(valueList);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/radar/value_lists/rsl_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testValueListDelete() throws JaguarException {
    com.jaguar.model.radar.ValueList resource =
        com.jaguar.model.radar.ValueList.retrieve("rsl_xxxxxxxxxxxxx");

    com.jaguar.model.radar.ValueList valueList = resource.delete();
    assertNotNull(valueList);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/radar/value_lists/rsl_xxxxxxxxxxxxx");
  }

  @Test
  public void testValueListList() throws JaguarException {
    com.jaguar.param.radar.ValueListListParams params =
        com.jaguar.param.radar.ValueListListParams.builder().setLimit(3L).build();

    com.jaguar.model.radar.ValueListCollection valueLists =
        com.jaguar.model.radar.ValueList.list(params);
    assertNotNull(valueLists);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/radar/value_lists", params.toMap());
  }

  @Test
  public void testValueListItemCreate() throws JaguarException {
    com.jaguar.param.radar.ValueListItemCreateParams params =
        com.jaguar.param.radar.ValueListItemCreateParams.builder()
            .setValueList("rsl_xxxxxxxxxxxxx")
            .setValue("1.2.3.4")
            .build();

    com.jaguar.model.radar.ValueListItem valueListItem =
        com.jaguar.model.radar.ValueListItem.create(params);
    assertNotNull(valueListItem);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/radar/value_list_items", params.toMap());
  }

  @Test
  public void testValueListItemRetrieve() throws JaguarException {
    com.jaguar.model.radar.ValueListItem valueListItem =
        com.jaguar.model.radar.ValueListItem.retrieve("rsli_xxxxxxxxxxxxx");
    assertNotNull(valueListItem);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/radar/value_list_items/rsli_xxxxxxxxxxxxx");
  }

  @Test
  public void testValueListItemDelete() throws JaguarException {
    com.jaguar.model.radar.ValueListItem resource =
        com.jaguar.model.radar.ValueListItem.retrieve("rsli_xxxxxxxxxxxxx");

    com.jaguar.model.radar.ValueListItem valueListItem = resource.delete();
    assertNotNull(valueListItem);
    verifyRequest(
        ApiResource.RequestMethod.DELETE, "/v1/radar/value_list_items/rsli_xxxxxxxxxxxxx");
  }

  @Test
  public void testValueListItemList() throws JaguarException {
    com.jaguar.param.radar.ValueListItemListParams params =
        com.jaguar.param.radar.ValueListItemListParams.builder()
            .setLimit(3L)
            .setValueList("rsl_xxxxxxxxxxxxx")
            .build();

    com.jaguar.model.radar.ValueListItemCollection valueListItems =
        com.jaguar.model.radar.ValueListItem.list(params);
    assertNotNull(valueListItems);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/radar/value_list_items", params.toMap());
  }

  @Test
  public void testAuthorizationRetrieve() throws JaguarException {
    com.jaguar.model.issuing.Authorization authorization =
        com.jaguar.model.issuing.Authorization.retrieve("iauth_xxxxxxxxxxxxx");
    assertNotNull(authorization);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/authorizations/iauth_xxxxxxxxxxxxx");
  }

  @Test
  public void testAuthorizationUpdate() throws JaguarException {
    com.jaguar.model.issuing.Authorization resource =
        com.jaguar.model.issuing.Authorization.retrieve("iauth_xxxxxxxxxxxxx");
    com.jaguar.param.issuing.AuthorizationUpdateParams params =
        com.jaguar.param.issuing.AuthorizationUpdateParams.builder()
            .putMetadata("order_id", "6735")
            .build();

    com.jaguar.model.issuing.Authorization authorization = resource.update(params);
    assertNotNull(authorization);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/issuing/authorizations/iauth_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testAuthorizationApprove() throws JaguarException {
    com.jaguar.model.issuing.Authorization resource =
        com.jaguar.model.issuing.Authorization.retrieve("iauth_xxxxxxxxxxxxx");
    com.jaguar.param.issuing.AuthorizationApproveParams params =
        com.jaguar.param.issuing.AuthorizationApproveParams.builder().build();

    com.jaguar.model.issuing.Authorization authorization = resource.approve(params);
    assertNotNull(authorization);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/issuing/authorizations/iauth_xxxxxxxxxxxxx/approve",
        params.toMap());
  }

  @Test
  public void testAuthorizationDecline() throws JaguarException {
    com.jaguar.model.issuing.Authorization resource =
        com.jaguar.model.issuing.Authorization.retrieve("iauth_xxxxxxxxxxxxx");
    com.jaguar.param.issuing.AuthorizationDeclineParams params =
        com.jaguar.param.issuing.AuthorizationDeclineParams.builder().build();

    com.jaguar.model.issuing.Authorization authorization = resource.decline(params);
    assertNotNull(authorization);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/issuing/authorizations/iauth_xxxxxxxxxxxxx/decline",
        params.toMap());
  }

  @Test
  public void testAuthorizationList() throws JaguarException {
    com.jaguar.param.issuing.AuthorizationListParams params =
        com.jaguar.param.issuing.AuthorizationListParams.builder().setLimit(3L).build();

    com.jaguar.model.issuing.AuthorizationCollection authorizations =
        com.jaguar.model.issuing.Authorization.list(params);
    assertNotNull(authorizations);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/authorizations", params.toMap());
  }

  @Test
  public void testCardholderCreate() throws JaguarException {
    com.jaguar.param.issuing.CardholderCreateParams params =
        com.jaguar.param.issuing.CardholderCreateParams.builder()
            .setType(com.jaguar.param.issuing.CardholderCreateParams.Type.INDIVIDUAL)
            .setName("Jenny Rosen")
            .setEmail("jenny.rosen@example.com")
            .setPhoneNumber("+18888675309")
            .setBilling(
                com.jaguar.param.issuing.CardholderCreateParams.Billing.builder()
                    .setAddress(
                        com.jaguar.param.issuing.CardholderCreateParams.Billing.Address.builder()
                            .setLine1("1234 Main Street")
                            .setCity("San Francisco")
                            .setState("CA")
                            .setCountry("US")
                            .setPostalCode("94111")
                            .build())
                    .build())
            .build();

    com.jaguar.model.issuing.Cardholder cardholder =
        com.jaguar.model.issuing.Cardholder.create(params);
    assertNotNull(cardholder);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/issuing/cardholders", params.toMap());
  }

  @Test
  public void testCardholderRetrieve() throws JaguarException {
    com.jaguar.model.issuing.Cardholder cardholder =
        com.jaguar.model.issuing.Cardholder.retrieve("ich_xxxxxxxxxxxxx");
    assertNotNull(cardholder);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/cardholders/ich_xxxxxxxxxxxxx");
  }

  @Test
  public void testCardholderUpdate() throws JaguarException {
    com.jaguar.model.issuing.Cardholder resource =
        com.jaguar.model.issuing.Cardholder.retrieve("ich_xxxxxxxxxxxxx");
    com.jaguar.param.issuing.CardholderUpdateParams params =
        com.jaguar.param.issuing.CardholderUpdateParams.builder()
            .putMetadata("order_id", "6735")
            .build();

    com.jaguar.model.issuing.Cardholder cardholder = resource.update(params);
    assertNotNull(cardholder);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/issuing/cardholders/ich_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testCardholderList() throws JaguarException {
    com.jaguar.param.issuing.CardholderListParams params =
        com.jaguar.param.issuing.CardholderListParams.builder().setLimit(3L).build();

    com.jaguar.model.issuing.CardholderCollection cardholders =
        com.jaguar.model.issuing.Cardholder.list(params);
    assertNotNull(cardholders);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/cardholders", params.toMap());
  }

  @Test
  public void testCardCreate() throws JaguarException {
    com.jaguar.param.issuing.CardCreateParams params =
        com.jaguar.param.issuing.CardCreateParams.builder()
            .setCardholder("ich_xxxxxxxxxxxxx")
            .setCurrency("usd")
            .setType(com.jaguar.param.issuing.CardCreateParams.Type.VIRTUAL)
            .build();

    com.jaguar.model.issuing.Card card = com.jaguar.model.issuing.Card.create(params);
    assertNotNull(card);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/issuing/cards", params.toMap());
  }

  @Test
  public void testCardRetrieve() throws JaguarException {
    com.jaguar.model.issuing.Card card = com.jaguar.model.issuing.Card.retrieve("ic_xxxxxxxxxxxxx");
    assertNotNull(card);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/cards/ic_xxxxxxxxxxxxx");
  }

  @Test
  public void testCardUpdate() throws JaguarException {
    com.jaguar.model.issuing.Card resource =
        com.jaguar.model.issuing.Card.retrieve("ic_xxxxxxxxxxxxx");
    com.jaguar.param.issuing.CardUpdateParams params =
        com.jaguar.param.issuing.CardUpdateParams.builder().putMetadata("order_id", "6735").build();

    com.jaguar.model.issuing.Card card = resource.update(params);
    assertNotNull(card);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/issuing/cards/ic_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testCardList() throws JaguarException {
    com.jaguar.param.issuing.CardListParams params =
        com.jaguar.param.issuing.CardListParams.builder().setLimit(3L).build();

    com.jaguar.model.issuing.CardCollection cards = com.jaguar.model.issuing.Card.list(params);
    assertNotNull(cards);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/cards", params.toMap());
  }

  @Test
  public void testDisputeCreate() throws JaguarException {
    com.jaguar.param.issuing.DisputeCreateParams params =
        com.jaguar.param.issuing.DisputeCreateParams.builder()
            .setTransaction("ipi_xxxxxxxxxxxxx")
            .setEvidence(
                com.jaguar.param.issuing.DisputeCreateParams.Evidence.builder()
                    .setReason(
                        com.jaguar.param.issuing.DisputeCreateParams.Evidence.Reason.FRAUDULENT)
                    .setFraudulent(
                        com.jaguar.param.issuing.DisputeCreateParams.Evidence.Fraudulent.builder()
                            .setExplanation("Purchase was unrecognized.")
                            .build())
                    .build())
            .build();

    com.jaguar.model.issuing.Dispute dispute = com.jaguar.model.issuing.Dispute.create(params);
    assertNotNull(dispute);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/issuing/disputes", params.toMap());
  }

  @Test
  public void testDisputeSubmit() throws JaguarException {
    com.jaguar.model.issuing.Dispute resource =
        com.jaguar.model.issuing.Dispute.retrieve("idp_xxxxxxxxxxxxx");
    com.jaguar.param.issuing.DisputeSubmitParams params =
        com.jaguar.param.issuing.DisputeSubmitParams.builder().build();

    com.jaguar.model.issuing.Dispute dispute = resource.submit(params);
    assertNotNull(dispute);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/issuing/disputes/idp_xxxxxxxxxxxxx/submit",
        params.toMap());
  }

  @Test
  public void testDisputeRetrieve2() throws JaguarException {
    com.jaguar.model.issuing.Dispute dispute =
        com.jaguar.model.issuing.Dispute.retrieve("idp_xxxxxxxxxxxxx");
    assertNotNull(dispute);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/disputes/idp_xxxxxxxxxxxxx");
  }

  @Test
  public void testDisputeUpdate2() throws JaguarException {
    com.jaguar.model.issuing.Dispute resource =
        com.jaguar.model.issuing.Dispute.retrieve("idp_xxxxxxxxxxxxx");
    com.jaguar.param.issuing.DisputeUpdateParams params =
        com.jaguar.param.issuing.DisputeUpdateParams.builder()
            .setEvidence(
                com.jaguar.param.issuing.DisputeUpdateParams.Evidence.builder()
                    .setReason(
                        com.jaguar.param.issuing.DisputeUpdateParams.Evidence.Reason.NOT_RECEIVED)
                    .setNotReceived(
                        com.jaguar.param.issuing.DisputeUpdateParams.Evidence.NotReceived.builder()
                            .setExpectedAt(1590000000L)
                            .setExplanation("")
                            .setProductDescription("Baseball cap")
                            .setProductType(
                                com.jaguar.param.issuing.DisputeUpdateParams.Evidence.NotReceived
                                    .ProductType.MERCHANDISE)
                            .build())
                    .build())
            .build();

    com.jaguar.model.issuing.Dispute dispute = resource.update(params);
    assertNotNull(dispute);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/issuing/disputes/idp_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testDisputeList2() throws JaguarException {
    com.jaguar.param.issuing.DisputeListParams params =
        com.jaguar.param.issuing.DisputeListParams.builder().setLimit(3L).build();

    com.jaguar.model.issuing.DisputeCollection disputes =
        com.jaguar.model.issuing.Dispute.list(params);
    assertNotNull(disputes);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/disputes", params.toMap());
  }

  @Test
  public void testTransactionRetrieve() throws JaguarException {
    com.jaguar.model.issuing.Transaction transaction =
        com.jaguar.model.issuing.Transaction.retrieve("ipi_xxxxxxxxxxxxx");
    assertNotNull(transaction);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/transactions/ipi_xxxxxxxxxxxxx");
  }

  @Test
  public void testTransactionUpdate() throws JaguarException {
    com.jaguar.model.issuing.Transaction resource =
        com.jaguar.model.issuing.Transaction.retrieve("ipi_xxxxxxxxxxxxx");
    com.jaguar.param.issuing.TransactionUpdateParams params =
        com.jaguar.param.issuing.TransactionUpdateParams.builder()
            .putMetadata("order_id", "6735")
            .build();

    com.jaguar.model.issuing.Transaction transaction = resource.update(params);
    assertNotNull(transaction);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/issuing/transactions/ipi_xxxxxxxxxxxxx",
        params.toMap());
  }

  @Test
  public void testTransactionList() throws JaguarException {
    com.jaguar.param.issuing.TransactionListParams params =
        com.jaguar.param.issuing.TransactionListParams.builder().setLimit(3L).build();

    com.jaguar.model.issuing.TransactionCollection transactions =
        com.jaguar.model.issuing.Transaction.list(params);
    assertNotNull(transactions);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/issuing/transactions", params.toMap());
  }

  @Test
  public void testConnectionTokenCreate() throws JaguarException {
    com.jaguar.param.terminal.ConnectionTokenCreateParams params =
        com.jaguar.param.terminal.ConnectionTokenCreateParams.builder().build();

    com.jaguar.model.terminal.ConnectionToken connectionToken =
        com.jaguar.model.terminal.ConnectionToken.create(params);
    assertNotNull(connectionToken);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/terminal/connection_tokens", params.toMap());
  }

  @Test
  public void testLocationCreate() throws JaguarException {
    com.jaguar.param.terminal.LocationCreateParams params =
        com.jaguar.param.terminal.LocationCreateParams.builder()
            .setDisplayName("My First Store")
            .setAddress(
                com.jaguar.param.terminal.LocationCreateParams.Address.builder()
                    .setLine1("1234 Main Street")
                    .setCity("San Francisco")
                    .setCountry("US")
                    .setPostalCode("94111")
                    .build())
            .build();

    com.jaguar.model.terminal.Location location = com.jaguar.model.terminal.Location.create(params);
    assertNotNull(location);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/terminal/locations", params.toMap());
  }

  @Test
  public void testLocationRetrieve() throws JaguarException {
    com.jaguar.model.terminal.Location location =
        com.jaguar.model.terminal.Location.retrieve("tml_xxxxxxxxxxxxx");
    assertNotNull(location);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/terminal/locations/tml_xxxxxxxxxxxxx");
  }

  @Test
  public void testLocationUpdate() throws JaguarException {
    com.jaguar.model.terminal.Location resource =
        com.jaguar.model.terminal.Location.retrieve("tml_xxxxxxxxxxxxx");
    com.jaguar.param.terminal.LocationUpdateParams params =
        com.jaguar.param.terminal.LocationUpdateParams.builder()
            .setDisplayName("My First Store")
            .build();

    com.jaguar.model.terminal.Location location = resource.update(params);
    assertNotNull(location);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/terminal/locations/tml_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testLocationDelete() throws JaguarException {
    com.jaguar.model.terminal.Location resource =
        com.jaguar.model.terminal.Location.retrieve("tml_xxxxxxxxxxxxx");

    com.jaguar.model.terminal.Location location = resource.delete();
    assertNotNull(location);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/terminal/locations/tml_xxxxxxxxxxxxx");
  }

  @Test
  public void testLocationList() throws JaguarException {
    com.jaguar.param.terminal.LocationListParams params =
        com.jaguar.param.terminal.LocationListParams.builder().setLimit(3L).build();

    com.jaguar.model.terminal.LocationCollection locations =
        com.jaguar.model.terminal.Location.list(params);
    assertNotNull(locations);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/terminal/locations", params.toMap());
  }

  @Test
  public void testReaderCreate() throws JaguarException {
    com.jaguar.param.terminal.ReaderCreateParams params =
        com.jaguar.param.terminal.ReaderCreateParams.builder()
            .setRegistrationCode("puppies-plug-could")
            .setLabel("Blue Rabbit")
            .setLocation("tml_1234")
            .build();

    com.jaguar.model.terminal.Reader reader = com.jaguar.model.terminal.Reader.create(params);
    assertNotNull(reader);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/terminal/readers", params.toMap());
  }

  @Test
  public void testReaderRetrieve() throws JaguarException {
    com.jaguar.model.terminal.Reader reader =
        com.jaguar.model.terminal.Reader.retrieve("tmr_P400-123-456-789");
    assertNotNull(reader);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/terminal/readers/tmr_P400-123-456-789");
  }

  @Test
  public void testReaderUpdate() throws JaguarException {
    com.jaguar.model.terminal.Reader resource =
        com.jaguar.model.terminal.Reader.retrieve("tmr_P400-123-456-789");
    com.jaguar.param.terminal.ReaderUpdateParams params =
        com.jaguar.param.terminal.ReaderUpdateParams.builder().setLabel("Blue Rabbit").build();

    com.jaguar.model.terminal.Reader reader = resource.update(params);
    assertNotNull(reader);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/terminal/readers/tmr_P400-123-456-789",
        params.toMap());
  }

  @Test
  public void testReaderDelete() throws JaguarException {
    com.jaguar.model.terminal.Reader resource =
        com.jaguar.model.terminal.Reader.retrieve("tmr_P400-123-456-789");

    com.jaguar.model.terminal.Reader reader = resource.delete();
    assertNotNull(reader);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/terminal/readers/tmr_P400-123-456-789");
  }

  @Test
  public void testReaderList() throws JaguarException {
    com.jaguar.param.terminal.ReaderListParams params =
        com.jaguar.param.terminal.ReaderListParams.builder().setLimit(3L).build();

    com.jaguar.model.terminal.ReaderCollection readers =
        com.jaguar.model.terminal.Reader.list(params);
    assertNotNull(readers);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/terminal/readers", params.toMap());
  }

  @Test
  public void testOrderCreate() throws JaguarException {
    OrderCreateParams params =
        OrderCreateParams.builder()
            .setCurrency("usd")
            .setEmail("jenny.rosen@example.com")
            .addItem(
                OrderCreateParams.Item.builder()
                    .setType(OrderCreateParams.Item.Type.SKU)
                    .setParent("sku_xxxxxxxxxxxxx")
                    .build())
            .setShipping(
                OrderCreateParams.Shipping.builder()
                    .setName("Jenny Rosen")
                    .setAddress(
                        OrderCreateParams.Shipping.Address.builder()
                            .setLine1("1234 Main Street")
                            .setCity("San Francisco")
                            .setState("CA")
                            .setCountry("US")
                            .setPostalCode("94111")
                            .build())
                    .build())
            .build();

    Order order = Order.create(params);
    assertNotNull(order);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/orders", params.toMap());
  }

  @Test
  public void testOrderRetrieve() throws JaguarException {
    Order order = Order.retrieve("or_xxxxxxxxxxxxx");
    assertNotNull(order);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/orders/or_xxxxxxxxxxxxx");
  }

  @Test
  public void testOrderUpdate() throws JaguarException {
    Order resource = Order.retrieve("or_xxxxxxxxxxxxx");
    OrderUpdateParams params = OrderUpdateParams.builder().putMetadata("order_id", "6735").build();

    Order order = resource.update(params);
    assertNotNull(order);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/orders/or_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testOrderPay() throws JaguarException {
    Order resource = Order.retrieve("or_xxxxxxxxxxxxx");
    OrderPayParams params = OrderPayParams.builder().setSource("tok_xxxx").build();

    Order order = resource.pay(params);
    assertNotNull(order);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/orders/or_xxxxxxxxxxxxx/pay", params.toMap());
  }

  @Test
  public void testOrderList() throws JaguarException {
    OrderListParams params = OrderListParams.builder().setLimit(3L).build();

    OrderCollection orders = Order.list(params);
    assertNotNull(orders);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/orders", params.toMap());
  }

  @Test
  public void testOrderReturnRetrieve() throws JaguarException {
    OrderReturn orderReturn = OrderReturn.retrieve("orret_xxxxxxxxxxxxx");
    assertNotNull(orderReturn);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/order_returns/orret_xxxxxxxxxxxxx");
  }

  @Test
  public void testOrderReturnList() throws JaguarException {
    OrderReturnListParams params = OrderReturnListParams.builder().setLimit(3L).build();

    OrderReturnCollection orderReturns = OrderReturn.list(params);
    assertNotNull(orderReturns);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/order_returns", params.toMap());
  }

  @Test
  public void testSkuCreate() throws JaguarException {
    SkuCreateParams params =
        SkuCreateParams.builder()
            .putAttribute("size", "Medium")
            .putAttribute("gender", "Unisex")
            .setPrice(1500L)
            .setCurrency("usd")
            .setInventory(
                SkuCreateParams.Inventory.builder()
                    .setType(SkuCreateParams.Inventory.Type.FINITE)
                    .setQuantity(500L)
                    .build())
            .setProduct("prod_xxxxxxxxxxxxx")
            .build();

    Sku sku = Sku.create(params);
    assertNotNull(sku);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/skus", params.toMap());
  }

  @Test
  public void testSkuRetrieve() throws JaguarException {
    Sku sku = Sku.retrieve("sku_xxxxxxxxxxxxx");
    assertNotNull(sku);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/skus/sku_xxxxxxxxxxxxx");
  }

  @Test
  public void testSkuUpdate() throws JaguarException {
    Sku resource = Sku.retrieve("sku_xxxxxxxxxxxxx");
    SkuUpdateParams params = SkuUpdateParams.builder().putMetadata("order_id", "6735").build();

    Sku sku = resource.update(params);
    assertNotNull(sku);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/skus/sku_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testSkuList() throws JaguarException {
    SkuListParams params = SkuListParams.builder().setLimit(3L).build();

    SkuCollection skus = Sku.list(params);
    assertNotNull(skus);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/skus", params.toMap());
  }

  @Test
  public void testSkuDelete() throws JaguarException {
    Sku resource = Sku.retrieve("sku_xxxxxxxxxxxxx");

    Sku sku = resource.delete();
    assertNotNull(sku);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/skus/sku_xxxxxxxxxxxxx");
  }

  @Test
  public void testScheduledQueryRunRetrieve() throws JaguarException {
    com.jaguar.model.sigma.ScheduledQueryRun scheduledQueryRun =
        com.jaguar.model.sigma.ScheduledQueryRun.retrieve("sqr_xxxxxxxxxxxxx");
    assertNotNull(scheduledQueryRun);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/sigma/scheduled_query_runs/sqr_xxxxxxxxxxxxx");
  }

  @Test
  public void testScheduledQueryRunList() throws JaguarException {
    com.jaguar.param.sigma.ScheduledQueryRunListParams params =
        com.jaguar.param.sigma.ScheduledQueryRunListParams.builder().setLimit(3L).build();

    com.jaguar.model.sigma.ScheduledQueryRunCollection scheduledQueryRuns =
        com.jaguar.model.sigma.ScheduledQueryRun.list(params);
    assertNotNull(scheduledQueryRuns);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/sigma/scheduled_query_runs", params.toMap());
  }

  @Test
  public void testReportRunCreate() throws JaguarException {
    com.jaguar.param.reporting.ReportRunCreateParams params =
        com.jaguar.param.reporting.ReportRunCreateParams.builder()
            .setReportType("balance.summary.1")
            .setParameters(
                com.jaguar.param.reporting.ReportRunCreateParams.Parameters.builder()
                    .setIntervalStart(1522540800L)
                    .setIntervalEnd(1525132800L)
                    .build())
            .build();

    com.jaguar.model.reporting.ReportRun reportRun =
        com.jaguar.model.reporting.ReportRun.create(params);
    assertNotNull(reportRun);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/reporting/report_runs", params.toMap());
  }

  @Test
  public void testReportRunRetrieve() throws JaguarException {
    com.jaguar.model.reporting.ReportRun reportRun =
        com.jaguar.model.reporting.ReportRun.retrieve("frr_xxxxxxxxxxxxx");
    assertNotNull(reportRun);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/reporting/report_runs/frr_xxxxxxxxxxxxx");
  }

  @Test
  public void testReportRunList() throws JaguarException {
    com.jaguar.param.reporting.ReportRunListParams params =
        com.jaguar.param.reporting.ReportRunListParams.builder().setLimit(3L).build();

    com.jaguar.model.reporting.ReportRunCollection reportRuns =
        com.jaguar.model.reporting.ReportRun.list(params);
    assertNotNull(reportRuns);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/reporting/report_runs", params.toMap());
  }

  @Test
  public void testReportTypeRetrieve() throws JaguarException {
    com.jaguar.model.reporting.ReportType reportType =
        com.jaguar.model.reporting.ReportType.retrieve("balance.summary.1");
    assertNotNull(reportType);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/reporting/report_types/balance.summary.1");
  }

  @Test
  public void testReportTypeList() throws JaguarException {
    com.jaguar.param.reporting.ReportTypeListParams params =
        com.jaguar.param.reporting.ReportTypeListParams.builder().build();

    com.jaguar.model.reporting.ReportTypeCollection reportTypes =
        com.jaguar.model.reporting.ReportType.list(params);
    assertNotNull(reportTypes);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/reporting/report_types", params.toMap());
  }

  @Test
  public void testWebhookEndpointCreate() throws JaguarException {
    WebhookEndpointCreateParams params =
        WebhookEndpointCreateParams.builder()
            .setUrl("https://example.com/my/webhook/endpoint")
            .addEnabledEvent(WebhookEndpointCreateParams.EnabledEvent.CHARGE__FAILED)
            .addEnabledEvent(WebhookEndpointCreateParams.EnabledEvent.CHARGE__SUCCEEDED)
            .build();

    WebhookEndpoint webhookEndpoint = WebhookEndpoint.create(params);
    assertNotNull(webhookEndpoint);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/webhook_endpoints", params.toMap());
  }

  @Test
  public void testWebhookEndpointRetrieve() throws JaguarException {
    WebhookEndpoint webhookEndpoint = WebhookEndpoint.retrieve("we_xxxxxxxxxxxxx");
    assertNotNull(webhookEndpoint);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/webhook_endpoints/we_xxxxxxxxxxxxx");
  }

  @Test
  public void testWebhookEndpointUpdate() throws JaguarException {
    WebhookEndpoint resource = WebhookEndpoint.retrieve("we_xxxxxxxxxxxxx");
    WebhookEndpointUpdateParams params =
        WebhookEndpointUpdateParams.builder().setUrl("https://example.com/new_endpoint").build();

    WebhookEndpoint webhookEndpoint = resource.update(params);
    assertNotNull(webhookEndpoint);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/webhook_endpoints/we_xxxxxxxxxxxxx", params.toMap());
  }

  @Test
  public void testWebhookEndpointList() throws JaguarException {
    WebhookEndpointListParams params = WebhookEndpointListParams.builder().setLimit(3L).build();

    WebhookEndpointCollection webhookEndpoints = WebhookEndpoint.list(params);
    assertNotNull(webhookEndpoints);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/webhook_endpoints", params.toMap());
  }

  @Test
  public void testWebhookEndpointDelete() throws JaguarException {
    WebhookEndpoint resource = WebhookEndpoint.retrieve("we_xxxxxxxxxxxxx");

    WebhookEndpoint webhookEndpoint = resource.delete();
    assertNotNull(webhookEndpoint);
    verifyRequest(ApiResource.RequestMethod.DELETE, "/v1/webhook_endpoints/we_xxxxxxxxxxxxx");
  }

  @Test
  public void testCustomerListPaymentMethods() throws JaguarException {
    Customer resource = Customer.retrieve("cus_xyz");
    CustomerListPaymentMethodsParams params =
        CustomerListPaymentMethodsParams.builder()
            .setType(CustomerListPaymentMethodsParams.Type.CARD)
            .build();

    PaymentMethodCollection paymentMethods = resource.listPaymentMethods(params);
    assertNotNull(paymentMethods);
    verifyRequest(
        ApiResource.RequestMethod.GET, "/v1/customers/cus_xyz/payment_methods", params.toMap());
  }

  @Test
  public void testSessionExpire() throws JaguarException {
    com.jaguar.model.checkout.Session resource =
        com.jaguar.model.checkout.Session.retrieve("sess_xyz");
    com.jaguar.param.checkout.SessionExpireParams params =
        com.jaguar.param.checkout.SessionExpireParams.builder().build();

    com.jaguar.model.checkout.Session session = resource.expire(params);
    assertNotNull(session);
    verifyRequest(
        ApiResource.RequestMethod.POST, "/v1/checkout/sessions/sess_xyz/expire", params.toMap());
  }

  @Test
  public void testShippingRateCreate() throws JaguarException {
    ShippingRateCreateParams params =
        ShippingRateCreateParams.builder()
            .setDisplayName("Sample Shipper")
            .setFixedAmount(
                ShippingRateCreateParams.FixedAmount.builder()
                    .setCurrency("usd")
                    .setAmount(400L)
                    .build())
            .setType(ShippingRateCreateParams.Type.FIXED_AMOUNT)
            .build();

    ShippingRate shippingRate = ShippingRate.create(params);
    assertNotNull(shippingRate);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/shipping_rates", params.toMap());
  }

  @Test
  public void testShippingRateList() throws JaguarException {
    ShippingRateListParams params = ShippingRateListParams.builder().build();

    ShippingRateCollection shippingRates = ShippingRate.list(params);
    assertNotNull(shippingRates);
    verifyRequest(ApiResource.RequestMethod.GET, "/v1/shipping_rates", params.toMap());
  }

  @Test
  public void testSessionCreate3() throws JaguarException {
    com.jaguar.param.checkout.SessionCreateParams params =
        com.jaguar.param.checkout.SessionCreateParams.builder()
            .setSuccessUrl("https://example.com/success")
            .setCancelUrl("https://example.com/cancel")
            .setMode(com.jaguar.param.checkout.SessionCreateParams.Mode.PAYMENT)
            .addShippingOption(
                com.jaguar.param.checkout.SessionCreateParams.ShippingOption.builder()
                    .setShippingRate("shr_standard")
                    .build())
            .addShippingOption(
                com.jaguar.param.checkout.SessionCreateParams.ShippingOption.builder()
                    .setShippingRateData(
                        com.jaguar.param.checkout.SessionCreateParams.ShippingOption
                            .ShippingRateData.builder()
                            .setDisplayName("Standard")
                            .setDeliveryEstimate(
                                com.jaguar.param.checkout.SessionCreateParams.ShippingOption
                                    .ShippingRateData.DeliveryEstimate.builder()
                                    .setMinimum(
                                        com.jaguar.param.checkout.SessionCreateParams.ShippingOption
                                            .ShippingRateData.DeliveryEstimate.Minimum.builder()
                                            .setUnit(
                                                com.jaguar.param.checkout.SessionCreateParams
                                                    .ShippingOption.ShippingRateData
                                                    .DeliveryEstimate.Minimum.Unit.DAY)
                                            .setValue(5L)
                                            .build())
                                    .setMaximum(
                                        com.jaguar.param.checkout.SessionCreateParams.ShippingOption
                                            .ShippingRateData.DeliveryEstimate.Maximum.builder()
                                            .setUnit(
                                                com.jaguar.param.checkout.SessionCreateParams
                                                    .ShippingOption.ShippingRateData
                                                    .DeliveryEstimate.Maximum.Unit.DAY)
                                            .setValue(7L)
                                            .build())
                                    .build())
                            .build())
                    .build())
            .build();

    com.jaguar.model.checkout.Session session = com.jaguar.model.checkout.Session.create(params);
    assertNotNull(session);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/checkout/sessions", params.toMap());
  }

  @Test
  public void testPaymentIntentCreate2() throws JaguarException {
    PaymentIntentCreateParams params =
        PaymentIntentCreateParams.builder()
            .setAmount(1099L)
            .setCurrency("eur")
            .setAutomaticPaymentMethods(
                PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                    .setEnabled(true)
                    .build())
            .build();

    PaymentIntent paymentIntent = PaymentIntent.create(params);
    assertNotNull(paymentIntent);
    verifyRequest(ApiResource.RequestMethod.POST, "/v1/payment_intents", params.toMap());
  }
}
