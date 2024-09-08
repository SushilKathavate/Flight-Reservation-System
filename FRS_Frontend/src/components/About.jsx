// import React from 'react';
// import './About.css'; // Import the custom CSS file
// import Header from './Header';
// import Footer from './Footer';

// function About() {
//   return (
//     <div className="about-container">
      
//       <div className="about-image-container">
//         <div className="image">
//           <img src="https://i.imgur.com/WbQnbas.png" alt="About Us" />
//         </div>
//       </div>
//       <div className="about-text-container">
//         <div className="text">
//           <span className="about-label">About us</span>
//           <h2 className="about-heading">
//             About <span className="highlight-text">Our Company</span>
//           </h2>
//           <p className="about-description">
//           Welcome to , your trusted partner in air travel. We are dedicated to providing seamless and affordable flight booking experiences, ensuring that your journey is as smooth as possible from start to finish. With a vast network of airline partners and an easy-to-use platform, we make it simple for you to find the best deals on flights to your favorite destinations around the globe. Whether you're traveling for business or leisure, we are committed to offering exceptional service and support, making your travel planning effortless and enjoyable. At [Your Company Name], your journey begins with us.
//           </p>
//         </div>
//       </div>
      
//     </div>
//   );
// }

// export default About;

import React from 'react';
import Header from './Header'; // Import the Header component
import Footer from './Footer'; // Import the Footer component
import './About.css'; // Import the custom CSS file

function About() {
  return (
    <div className="about-page">
      <Header/> {/* Add the Header at the top */}
      <div className="about-container">
        <div className="about-image-container">
          <div className="image">
            <img src="https://i.imgur.com/WbQnbas.png" alt="About Us" />
          </div>
        </div>
        <div className="about-text-container">
          <div className="text">
            <span className="about-label">About us</span>
            <h2 className="about-heading">
              About <span className="highlight-text">Our Company</span>
            </h2>
            <p className="about-description">
              Welcome to Flight Reservation, your trusted partner in air travel. We are dedicated to providing seamless and affordable flight booking experiences, ensuring that your journey is as smooth as possible from start to finish. With a vast network of airline partners and an easy-to-use platform, we make it simple for you to find the best deals on flights to your favorite destinations around the globe. Whether you're traveling for business or leisure, we are committed to offering exceptional service and support, making your travel planning effortless and enjoyable. At [Your Company Name], your journey begins with us.
            </p>
          </div>
        </div>
      </div>
      <Footer/> {/* Add the Footer at the bottom */}
    </div>
  );
}

export default About;
