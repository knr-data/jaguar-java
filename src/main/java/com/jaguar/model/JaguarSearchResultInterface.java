package com.jaguar.model;

/**
 * Please note, StripeSearchResultInterface is beta functionality and is subject to change or
 * removal at any time.
 */
public interface JaguarSearchResultInterface<T> extends JaguarCollectionInterface<T> {
  String getNextPage();
}
