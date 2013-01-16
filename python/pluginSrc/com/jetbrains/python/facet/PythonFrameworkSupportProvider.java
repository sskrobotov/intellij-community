package com.jetbrains.python.facet;

import com.intellij.facet.FacetManager;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportConfigurable;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportProvider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.jetbrains.python.module.PythonModuleType;
import icons.PythonIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author yole
 */
public class PythonFrameworkSupportProvider extends FrameworkSupportProvider {
  public PythonFrameworkSupportProvider() {
    super("Python", PythonFacetType.getInstance().getPresentableName());
  }

  @Override
  public Icon getIcon() {
    return PythonIcons.Python.Python;
  }

  @NotNull
  @Override
  public FrameworkSupportConfigurable createConfigurable(@NotNull FrameworkSupportModel model) {
    return new PythonFrameworkSupportConfigurable(model);
  }

  public boolean isEnabledForModuleType(@NotNull ModuleType moduleType) {
    return !(moduleType instanceof PythonModuleType);
  }

  @Override
  public boolean isSupportAlreadyAdded(@NotNull Module module) {
    return FacetManager.getInstance(module).getFacetsByType(PythonFacetType.getInstance().getId()).size() > 0;
  }
}
