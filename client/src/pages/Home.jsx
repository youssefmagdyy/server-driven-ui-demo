import { useEffect, useState } from "react";
import axios from "axios";
import "../styles/Home.css";
import { renderComponent } from "../utils";

const Homepage = () => {
  const [pageData, setPageData] = useState(null);

  useEffect(() => {
    axios
      .get("http://localhost:8080/page/home")
      .then((res) => {
        setPageData(res.data)
        console.log(res.data)
    })
      .catch((err) => console.error(err));
  }, []);


  return (
    <div className="homepage">
      {pageData ? pageData.components.map((comp, index) => 
        renderComponent(comp,index)
    )
    : 
    <div className="loaderContainer">
          <span className="loader"></span>
    </div>
    }
    </div>
    );
};

export default Homepage;
