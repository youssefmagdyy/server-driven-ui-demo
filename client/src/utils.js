import Header from "./components/Header";
import Banner from "./components/Banner";
import Grid from "./components/Grid";
import Navbar from "./components/Navbar";
import Navlink from "./components/Navlink";

export const renderComponent = (component, key) => {
  const Component = componentMap[component.name];
  if (!Component)  console.log(`Component ${component.name} not found`);

  const children = component.children?.map((child, i) =>
    renderComponent(child, i)
  );

  return (
    <Component key={key} {...component.props}>
      {children}
    </Component>
  );
};

export const componentMap = {
  Header,
  Banner,
  Grid,
  Navbar,
  Navlink
};
