package com.innovation.utils.networkmanager;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class IConnectivityManagerImpl_Factory implements Factory<IConnectivityManagerImpl> {
  private final Provider<Context> contextProvider;

  public IConnectivityManagerImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public IConnectivityManagerImpl get() {
    return newInstance(contextProvider.get());
  }

  public static IConnectivityManagerImpl_Factory create(Provider<Context> contextProvider) {
    return new IConnectivityManagerImpl_Factory(contextProvider);
  }

  public static IConnectivityManagerImpl newInstance(Context context) {
    return new IConnectivityManagerImpl(context);
  }
}
