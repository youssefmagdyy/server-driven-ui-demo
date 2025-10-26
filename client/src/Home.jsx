import { useEffect, useState } from "react";
import axios from "axios";
import componentMap from "./components/CompMapper";

const Homepage = () => {
  const [pageData, setPageData] = useState(null);

  useEffect(() => {
    axios
      .get("http://localhost:8080/page/home")
      .then((res) => {
        setPageData(res.data)
    })
      .catch((err) => console.error(err));
  }, []);

  const alertComponentNotFound = (comp) => {
    console.log(`Component ${comp} not found`)
    return null;
  }

  return (
    <div>
      {pageData ? pageData.components.map((comp, index) => {
        const Component = componentMap[comp.name];
        if (!Component) alertComponentNotFound(comp.name); // skip unknown components
        return <Component key={index} {...comp.props} />;
      }
    )
    :
<p>Loading...</p>
}
    </div>
  );
};

export default Homepage;
